package com.tuna.nothingapp.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.tuna.nothingapp.R
import com.tuna.nothingapp.databinding.DialogProgressLoadingBinding

class ProgressLoadingDialog : DialogFragment() {

    lateinit var binding: DialogProgressLoadingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogProgressLoadingBinding.inflate(inflater, container, false)
        isCancelable = false
        return binding.root
    }

    companion object {
        private const val PROGRESS_DIALOG_TAG = "PROGRESS_TAG"

        fun show(fm: FragmentManager) {
            try {
                val dialog = fm.findFragmentByTag(PROGRESS_DIALOG_TAG)
                if (dialog != null && dialog is ProgressLoadingDialog &&
                    dialog.dialog?.isShowing == true
                ) {
                    return
                }
                val dialogFragment = ProgressLoadingDialog()
                dialogFragment.setStyle(STYLE_NORMAL, R.style.DialogBottomSheetDialogTransparent)
                dialogFragment.show(fm, PROGRESS_DIALOG_TAG)
            } catch (ignored: Exception) {
            }
        }

        fun hide(fm: FragmentManager) {
            try {
                val dialog = fm.findFragmentByTag(PROGRESS_DIALOG_TAG)
                if (dialog != null &&
                    dialog is ProgressLoadingDialog &&
                    dialog.dialog?.isShowing == true
                ) {
                    dialog.dismiss()
                }
            } catch (ignored: Exception) {
            }
        }
    }
}
