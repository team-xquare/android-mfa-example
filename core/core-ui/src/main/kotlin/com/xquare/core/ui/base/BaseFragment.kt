package com.xquare.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.xquare.core.ui.util.autoCleared

/**
 * referenced from [MVVMHabit](https://github.com/goldze/MVVMHabit/blob/ab2bf079815e260501e2f42b10c1b67329b1de26/mvvmhabit/src/main/java/me/goldze/mvvmhabit/base/BaseActivity.java)
 */
abstract class BaseFragment<B : ViewDataBinding>(
    @LayoutRes private val contentLayoutId: Int,
) : Fragment(contentLayoutId) {

    protected var binding: B by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, contentLayoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        initViewDataBinding(savedInstanceState)
        initUi(savedInstanceState)
    }

    protected open fun initViewDataBinding(savedInstanceState: Bundle?) {
        binding.run {
            lifecycleOwner = this@BaseFragment
        }
    }

    protected open fun initUi(savedInstanceState: Bundle?) {}
}
