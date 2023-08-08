package com.xquare.androidv2.fragment.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xquare.androidv2.R
import com.xquare.androidv2.databinding.FragmentServicesMainBinding

// todo make base fragment component
internal class MainFragment : Fragment(R.layout.fragment_services_main) {

    private var _binding: FragmentServicesMainBinding? = null
    private val binding: FragmentServicesMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentServicesMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
