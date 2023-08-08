package com.xquare.androidv2.di

import com.xquare.androidv2.BuildConfig
import com.xquare.androidv2.RootViewModel
import com.xquare.core.common.di.DiQualifier
import com.xquare.core.common.di.commonModule
import com.xquare.core.data.di.dataModule
import com.xquare.core.database.di.databaseModule
import com.xquare.core.datastore.di.dataStoreModule
import com.xquare.core.network.di.networkModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val xquareModule = module {
    includes(coreModule)
    single(qualifier = named(DiQualifier.Build.DEBUG)) { BuildConfig.DEBUG }
    viewModel { RootViewModel() }
    viewModelOf(::RootViewModel)
}

private val coreModule: Module
    get() = module {
        includes(
            commonModule,
            dataModule,
            databaseModule,
            dataStoreModule,
            networkModule,
        )
    }
