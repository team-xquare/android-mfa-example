package com.xquare.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * referenced from [MVVMHabit](https://github.com/goldze/MVVMHabit/blob/ab2bf079815e260501e2f42b10c1b67329b1de26/mvvmhabit/src/main/java/me/goldze/mvvmhabit/base/BaseActivity.java)
 */
abstract class BaseActivity<B : ViewDataBinding>(
    @LayoutRes private val contentLayoutId: Int,
) : AppCompatActivity(contentLayoutId) {

    protected val binding: B by lazy {
        DataBindingUtil.setContentView(this@BaseActivity, contentLayoutId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewDataBinding(savedInstanceState)
        initUi(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    protected open fun initViewDataBinding(savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = this@BaseActivity
        }
    }

    protected open fun initUi(savedInstanceState: Bundle?) {}
}
