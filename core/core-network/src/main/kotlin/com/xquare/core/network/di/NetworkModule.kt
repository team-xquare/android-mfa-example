package com.xquare.core.network.di

import com.xquare.core.network.apiservice.MealApiService
import com.xquare.core.network.apiservice.MealApiServiceImpl
import com.xquare.core.network.client.httpClient
import com.xquare.core.network.datasource.MealNetworkDataSource
import com.xquare.core.network.datasource.MealNetworkDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module
    get() = module {
        includes(
            dataSourceModule,
            apiServiceModule,
        )
        single { httpClient }
    }

private val dataSourceModule: Module
    get() = module {
        single<MealNetworkDataSource> { MealNetworkDataSourceImpl(get()) }
    }

private val apiServiceModule: Module
    get() = module {
        single<MealApiService> { MealApiServiceImpl(get()) }
    }
