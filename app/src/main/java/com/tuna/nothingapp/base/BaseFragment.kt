package com.tuna.nothingapp.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavBackStackEntry
import androidx.navigation.fragment.findNavController
import cn.pedant.SweetAlert.SweetAlertDialog
import com.tuna.nothingapp.R
import com.tuna.nothingapp.extensions.showToast
import com.tuna.nothingapp.navigation.NavigationCommand
import com.tuna.nothingapp.navigation.Navigator
import com.tuna.nothingapp.utils.ProgressLoadingDialog
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {
    protected lateinit var binding: DB
    private lateinit var dialog: SweetAlertDialog
    protected abstract val viewModel: VM

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun getViewModelBindingVariable(): Int
    protected abstract fun initView()
    protected abstract fun initData()

    protected open fun handleBackStackEntry(navBackStackEntry: NavBackStackEntry) {}

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(navigator)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(getViewModelBindingVariable(), viewModel)
        }
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        setupBackStackObserver()
        observerEventNavigate()
        dialog = SweetAlertDialog(requireContext())
    }

    fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        requireActivity().showToast(message, duration)
    }

    fun showLoading() {
        ProgressLoadingDialog.show(childFragmentManager)
    }

    fun hideLoading() {
        ProgressLoadingDialog.hide(childFragmentManager)
    }

    fun showErrorDialog(
        title: String = getString(R.string.error),
        message: String,
        positiveButton: String?,
        onPositive: () -> Unit
    ) {
        dialog = SweetAlertDialog(requireContext(), SweetAlertDialog.ERROR_TYPE)
            .setTitleText(title)
            .setContentText(message)
            .setConfirmButton(positiveButton) {
                onPositive.invoke()
            }
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)
        dialog.confirmButtonBackgroundColor = R.color.primary_reverse
        dialog.confirmButtonTextColor = R.color.primary
    }

    fun hideDialog() {
        dialog.hide()
    }

    private fun setupBackStackObserver() {
        val navController = navigator.navController ?: return
        val currentDestinationId = navController.currentDestination?.id ?: return
        val navBackStackEntry = navController.getBackStackEntry(currentDestinationId)
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) handleBackStackEntry(navBackStackEntry)
        }

        navBackStackEntry.lifecycle.addObserver(observer)

        lifecycle.addObserver(
            LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_DESTROY) {
                    navBackStackEntry.lifecycle.removeObserver(observer)
                }
            }
        )
    }

    private fun observerEventNavigate() {
        viewModel.navigateEvent.observeSingle(viewLifecycleOwner) {
            it?.let { command ->
                when (command) {
                    is NavigationCommand.To -> {
                        with(findNavController()) {
                            val actionId = command.directions.actionId
                            val action =
                                currentDestination?.getAction(actionId) ?: graph.getAction(
                                    actionId
                                )
                            if (action != null && currentDestination?.id != action.destinationId) {
                                command.navExtras?.run {
                                    navigate(command.directions, this)
                                } ?: run {
                                    navigate(command.directions)
                                }
                            }
                        }
                    }
                    is NavigationCommand.ParentTo -> {
                        getRootNestedNavController()?.run {
                            val actionId = command.directions.actionId
                            val action =
                                currentDestination?.getAction(actionId) ?: graph.getAction(
                                    actionId
                                )
                            if (action != null && currentDestination?.id != action.destinationId) {
                                navigate(command.directions)
                            }
                        } ?: run {
                            getNestedNavController()?.run {
                                val actionId = command.directions.actionId
                                val action =
                                    currentDestination?.getAction(actionId) ?: graph.getAction(
                                        actionId
                                    )
                                if (action != null && currentDestination?.id != action.destinationId) {
                                    navigate(command.directions)
                                }
                            }
                        }
                    }
                    is NavigationCommand.DeepLinkTo -> {
                        try {
                            findNavController().navigate(command.uri)
                        } catch (e: Exception) {
                            Log.d("NavigationCommand", e.toString())
                        }
                    }
                    is NavigationCommand.ParentDeepLinkTo -> {
                        try {
                            getNestedNavController()?.navigate(command.uri)
                        } catch (e: Exception) {
                            Log.d("NavigationCommand", e.toString())
                        }
                    }
                    is NavigationCommand.BackTo -> findNavController().popBackStack(
                        command.destinationId,
                        command.inclusive
                    )
                    is NavigationCommand.Back -> findNavController().popBackStack()
                    is NavigationCommand.ToRoot -> {
                        findNavController().popBackStack(
                            findNavController().graph.startDestinationId,
                            false
                        )
                    }
                }
            }
        }
    }

    // check if this fragment is under to nested parent (nav_host_fragment -> bottom_nav_host_fragment -> self)
    private fun getNestedNavController() = ((parentFragment)?.parentFragment)?.findNavController()
        ?: parentFragment?.findNavController()

    // check if this fragment is under to nested parent (nav_host_fragment -> bottom_nav_host_fragment -> fragment(component) -> self)
    private fun getRootNestedNavController() =
        parentFragment?.parentFragment?.parentFragment?.findNavController()


}