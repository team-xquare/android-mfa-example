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
    protected abstract val viewModel: VM

    /**
     * can be null when not using data binding.
     */
    protected open val viewModelId: Int? = null

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModelDataCallBack()
    }

    override fun initViewDataBinding(savedInstanceState: Bundle?) {
        super.initViewDataBinding(savedInstanceState)
        binding.run {
            if (viewModelId != null) {
                setVariable(viewModelId!!, viewModel)
            }
        }
    }

    protected open fun registerViewModelDataCallBack() {}
}
