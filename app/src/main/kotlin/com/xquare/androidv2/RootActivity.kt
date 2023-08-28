package com.xquare.androidv2

import android.os.Bundle
import com.xquare.androidv2.databinding.ActivityRootBinding
import com.xquare.core.ui.base.BaseViewModelActivity
import com.xquare.core.ui.util.addSystemBarsPaddingOnScreen
import com.xquare.core.ui.util.removeSystemBars
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class RootActivity : BaseViewModelActivity<ActivityRootBinding, RootActivityViewModel>(
    contentLayoutId = R.layout.activity_root,
) {
    override val viewModel: RootActivityViewModel by viewModel()

    override fun initUi(savedInstanceState: Bundle?) {
        removeSystemBars()
        addSystemBarsPaddingOnScreen(binding.root)
    }
}
