package com.xquare.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int,
) : BaseActivity<B>(
    contentLayoutId = contentLayoutId,
) {
    protected abstract val viewModelId: Int
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewModelDataCallBack()
    }

    override fun initViewDataBinding(savedInstanceState: Bundle?) {
        super.initViewDataBinding(savedInstanceState)
        binding.run { setVariable(viewModelId, viewModel) }
    }

    protected open fun registerViewModelDataCallBack() {}
}
