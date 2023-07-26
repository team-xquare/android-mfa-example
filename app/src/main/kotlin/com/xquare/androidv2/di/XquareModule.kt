package com.xquare.androidv2.di

import com.xquare.androidv2.MainActivityViewModel
import com.xquare.core.common.di.commonModule
import com.xquare.core.data.di.dataModule
import com.xquare.core.database.di.databaseModule
import com.xquare.core.datastore.di.dataStoreModule
import com.xquare.core.network.di.networkModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val xquareModule = module {
    includes(coreModule)
    viewModel { MainActivityViewModel() }
    viewModelOf(::MainActivityViewModel)
}

val coreModule = module {
    includes(
        commonModule,
        dataModule,
        databaseModule,
        dataStoreModule,
        networkModule,
    )
}
