package com.xquare.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding, VM : ViewModel>(
    @LayoutRes contentLayoutId: Int,
) : AppCompatActivity(contentLayoutId) {

    protected val binding: B by lazy {
        DataBindingUtil.setContentView(this@BaseActivity, contentLayoutId)
    }

    protected open val viewModel: VM
        get() = throw NotImplementedError()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}
