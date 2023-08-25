package com.xquare.domain.meal.di

import com.xquare.common.project.baseUrl
import com.xquare.domain.meal.datasource.database.MealDatabaseDataSource
import com.xquare.domain.meal.datasource.database.MealDatabaseDataSourceImpl
import com.xquare.domain.meal.datasource.database.service.MealDatabaseService
import com.xquare.domain.meal.datasource.database.service.MealDatabaseServiceImpl
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSource
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSourceImpl
import com.xquare.domain.meal.datasource.datastore.service.MealDataStoreService
import com.xquare.domain.meal.datasource.datastore.service.MealDataStoreServiceImpl
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

        single<MealRepository> { MealRepositoryImpl(get(), get(), get(), get(), get()) }
    }

private val dataSourceModule: Module
    get() = module {
        single<MealDatabaseDataSource> { MealDatabaseDataSourceImpl(get()) }
        single<MealDatabaseService> { MealDatabaseServiceImpl() }

        single<MealDataStoreDataSource> { MealDataStoreDataSourceImpl(get()) }
        single<MealDataStoreService> { MealDataStoreServiceImpl(get()) }

        single<MealNetworkDataSource> { MealNetworkDataSourceImpl(get()) }
        single<MealNetworkService> {
            MealNetworkServiceImpl(
                httpClient = get(),
                baseUri = "$baseUrl/meals",
            )
        }
    }

private val useCaseModule: Module
    get() = module {
    }
