package com.xquare.androidv2.fragment.services

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.xquare.androidv2.R
import com.xquare.androidv2.databinding.FragmentServicesMainBinding
import com.xquare.core.ui.base.BaseFragment
import com.xquare.core.ui.util.measuredSystemNavigationBarHeight

internal class MainFragment : BaseFragment<FragmentServicesMainBinding>(
    contentLayoutId = R.layout.fragment_services_main,
) {
    private val systemNavigationHeight: Int
        get() = context.measuredSystemNavigationBarHeight

    private val navHostFragment: NavHostFragment
        get() = childFragmentManager.findFragmentById(R.id.nav_host_services_main) as NavHostFragment
    private val navController: NavController
        get() = navHostFragment.navController

    override fun initUi(savedInstanceState: Bundle?) {
        super.initUi(savedInstanceState)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.includedLayoutServicesMain.bottomNav.run {
            setPadding(0, 0, 0, systemNavigationHeight)
            setupWithNavController(navController)
        }
    }
}
