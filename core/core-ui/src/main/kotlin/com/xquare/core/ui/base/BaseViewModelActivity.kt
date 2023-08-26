package com.xquare.core.ui.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseViewModelActivity<B : ViewDataBinding, VM : ViewModel>(
    @LayoutRes contentLayoutId: Int,
) : BaseActivity<B>(
    contentLayoutId = contentLayoutId,
)
