package com.xquare.androidv2

import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
}
