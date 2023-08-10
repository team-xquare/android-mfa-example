package com.xquare.androidv2.fragment.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xquare.androidv2.R
import com.xquare.androidv2.databinding.FragmentServicesMainBinding
import com.xquare.core.ui.util.measuredSystemNavigationBarHeight
import com.xquare.core.ui.util.measuredSystemStatusBarHeight

// todo make base fragment component
internal class MainFragment : Fragment(R.layout.fragment_services_main) {

    private var _binding: FragmentServicesMainBinding? = null
    private val binding: FragmentServicesMainBinding
        get() = _binding!!

    private val navHostFragment: NavHostFragment
        get() = childFragmentManager.findFragmentById(R.id.nav_host_fragment_content_services_main) as NavHostFragment

    private val systemNavigationHeight: Int
        get() = context.measuredSystemNavigationBarHeight

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentServicesMainBinding.inflate(inflater, container, false)

        val navView = binding.includedLayoutServicesMain.bottomNavigationServicesMain
        navView.setPadding(0, 0, 0, systemNavigationHeight)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
