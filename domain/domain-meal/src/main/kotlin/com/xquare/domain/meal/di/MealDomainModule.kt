package com.xquare.domain.meal.di

import com.xquare.domain.meal.datasource.database.MealDatabaseDataSource
import com.xquare.domain.meal.datasource.database.MealDatabaseDataSourceImpl
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSource
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSourceImpl
import com.xquare.domain.meal.datasource.network.MealNetworkDataSource
import com.xquare.domain.meal.datasource.network.MealNetworkDataSourceImpl
import com.xquare.domain.meal.datasource.network.apiservice.MealApiService
import com.xquare.domain.meal.datasource.network.apiservice.MealApiServiceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val mealDomainModule: Module
    get() = module {
        includes(
            dataSourceModule,
            useCaseModule,
        )
    }

private val dataSourceModule: Module
    get() = module {
        single<MealDatabaseDataSource> { MealDatabaseDataSourceImpl(get()) }
        single<MealDataStoreDataSource> { MealDataStoreDataSourceImpl(get()) }
        single<MealNetworkDataSource> { MealNetworkDataSourceImpl(get()) }
        single<MealApiService> { MealApiServiceImpl(get()) }
    }

private val useCaseModule: Module
    get() = module {
    }
