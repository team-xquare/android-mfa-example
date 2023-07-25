package com.xquare.androidv2.di

import com.xquare.androidv2.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val xquareModule = module {
    includes(
        coreModule,
        featureModule,
    )
    viewModel { MainActivityViewModel() }
    viewModelOf(::MainActivityViewModel)
}

private val coreModule = module {}
private val featureModule = module {}
