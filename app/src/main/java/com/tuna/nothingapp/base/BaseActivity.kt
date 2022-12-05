package com.tuna.nothingapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    protected abstract val viewModel: VM
    protected lateinit var binding: DB

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun getViewModelBindingVariable(): Int
    protected abstract fun initView()
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(getViewModelBindingVariable(), viewModel)

        initView()
        initData()
    }
}
