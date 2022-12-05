package com.tuna.nothingapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.tuna.nothingapp.extensions.showToast
import com.tuna.nothingapp.utils.ProgressLoadingDialog
import com.tuna.nothingapp.viewmodel.MainSharedViewModel

abstract class BaseFragment<DB: ViewDataBinding> : Fragment() {
    protected lateinit var binding: DB

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
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
}