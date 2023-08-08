package com.xquare.androidv2

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.xquare.androidv2.databinding.ActivityRootBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class RootActivity : AppCompatActivity() {
    private val viewModel: RootViewModel by viewModel()
    private val binding by lazy { ActivityRootBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initSystemBars()
    }
}

// todo move to util
fun Activity.initSystemBars() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    window.apply {
        setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )
    }
}