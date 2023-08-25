package com.xquare.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
) : AppCompatActivity(contentLayoutId) {

    private val binding: B by lazy {
        DataBindingUtil.setContentView(this@BaseActivity, contentLayoutId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}
