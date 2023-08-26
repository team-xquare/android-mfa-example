package com.xquare.core.ui.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseViewModelFragment<B : ViewDataBinding, VM : ViewModel>(
    @LayoutRes contentLayoutId: Int,
) : BaseFragment<B>(
    contentLayoutId = contentLayoutId,
)
