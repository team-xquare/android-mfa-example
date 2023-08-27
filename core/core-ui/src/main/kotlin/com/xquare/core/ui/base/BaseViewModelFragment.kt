package com.xquare.core.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class BaseViewModelFragment<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int,
) : BaseFragment<B>(
    contentLayoutId = contentLayoutId,
) {
    protected abstract val viewModelId: Int
    protected abstract val viewModel: VM

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModelDataCallBack()
    }

    protected open fun registerViewModelDataCallBack() {}
}
