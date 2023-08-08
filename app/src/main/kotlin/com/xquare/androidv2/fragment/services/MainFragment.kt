package com.xquare.androidv2.fragment.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xquare.androidv2.R
import com.xquare.androidv2.databinding.FragmentMainBinding

// todo make base fragment component
internal class MainFragment : Fragment(R.layout.content_main) {

    private var _binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
