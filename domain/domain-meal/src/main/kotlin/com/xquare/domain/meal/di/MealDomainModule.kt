package com.xquare.domain.meal.di

import com.xquare.domain.meal.datasource.database.MealDatabaseDataSource
import com.xquare.domain.meal.datasource.database.MealDatabaseDataSourceImpl
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSource
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSourceImpl
import com.xquare.domain.meal.datasource.network.MealNetworkDataSource
import com.xquare.domain.meal.datasource.network.MealNetworkDataSourceImpl
import com.xquare.domain.meal.datasource.network.service.MealNetworkService
import com.xquare.domain.meal.datasource.network.service.MealNetworkServiceImpl
import com.xquare.domain.meal.repository.MealRepository
import com.xquare.domain.meal.repository.MealRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val mealDomainModule: Module
    get() = module {
        includes(
            dataSourceModule,
            useCaseModule,
        )

        single<MealRepository> { MealRepositoryImpl(get(), get(), get()) }
    }

private val dataSourceModule: Module
    get() = module {
        single<MealDatabaseDataSource> { MealDatabaseDataSourceImpl(get()) }
        single<MealDataStoreDataSource> { MealDataStoreDataSourceImpl(get()) }
        single<MealNetworkDataSource> { MealNetworkDataSourceImpl(get()) }
        single<MealNetworkService> { MealNetworkServiceImpl(get()) }
    }

private val useCaseModule: Module
    get() = module {
    }
