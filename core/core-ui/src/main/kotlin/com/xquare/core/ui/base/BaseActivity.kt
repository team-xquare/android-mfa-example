package com.xquare.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * referenced from [MVVMHabit](https://github.com/goldze/MVVMHabit/blob/ab2bf079815e260501e2f42b10c1b67329b1de26/mvvmhabit/src/main/java/me/goldze/mvvmhabit/base/BaseActivity.java)
 */
abstract class BaseActivity<B : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
) : AppCompatActivity(contentLayoutId) {

    protected var binding: B? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}
