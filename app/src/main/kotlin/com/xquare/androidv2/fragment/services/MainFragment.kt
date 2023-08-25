package com.xquare.androidv2.fragment.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.xquare.androidv2.R
import com.xquare.androidv2.databinding.FragmentServicesMainBinding
import com.xquare.core.ui.util.measuredSystemNavigationBarHeight

// todo make base fragment component
internal class MainFragment : Fragment(R.layout.fragment_services_main) {

    private var _binding: FragmentServicesMainBinding? = null
    private val binding: FragmentServicesMainBinding
        get() = _binding!!

    private val systemNavigationHeight: Int
        get() = context.measuredSystemNavigationBarHeight

    private val navHostFragment: NavHostFragment
        get() = childFragmentManager.findFragmentById(R.id.nav_host_services_main) as NavHostFragment
    private val navController: NavController
        get() = navHostFragment.navController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentServicesMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.includedLayoutServicesMain.bottomNav.run {
            setPadding(0, 0, 0, systemNavigationHeight)
            setupWithNavController(navController)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
