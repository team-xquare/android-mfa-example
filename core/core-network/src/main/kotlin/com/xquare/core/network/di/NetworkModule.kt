package com.xquare.core.network.di

import com.xquare.core.network.apiservice.MealApiService
import com.xquare.core.network.apiservice.MealApiServiceImpl
import com.xquare.core.network.client.httpClient
import com.xquare.core.network.datasource.MealNetworkDataSource
import com.xquare.core.network.datasource.MealNetworkDataSourceImpl
import org.koin.dsl.module

val networkModule = module {
    includes(
        dataSourceModule,
        apiServiceModule,
    )
    single { httpClient }
}

private val dataSourceModule = module {
    single<MealNetworkDataSource> { MealNetworkDataSourceImpl(get()) }
}

private val apiServiceModule = module {
    single<MealApiService> { MealApiServiceImpl(get()) }
}
