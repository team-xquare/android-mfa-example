package com.xquare.core.network.di

import com.xquare.core.network.datasource.MealNetworkDataSource
import com.xquare.core.network.datasource.MealNetworkDataSourceImpl
import org.koin.dsl.module

val networkModule = module {
    includes(dataSourceModule)
}

private val dataSourceModule = module {
    single<MealNetworkDataSource> { MealNetworkDataSourceImpl() }
}
