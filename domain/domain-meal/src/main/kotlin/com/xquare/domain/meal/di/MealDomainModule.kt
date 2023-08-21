package com.xquare.domain.meal.di

import com.xquare.domain.meal.datasource.network.MealNetworkDataSource
import com.xquare.domain.meal.datasource.network.MealNetworkDataSourceImpl
import com.xquare.domain.meal.datasource.network.apiservice.MealApiService
import com.xquare.domain.meal.datasource.network.apiservice.MealApiServiceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val mealDomainModule: Module
    get() = module {
        single<MealNetworkDataSource> { MealNetworkDataSourceImpl(get()) }
        single<MealApiService> { MealApiServiceImpl(get()) }
    }
