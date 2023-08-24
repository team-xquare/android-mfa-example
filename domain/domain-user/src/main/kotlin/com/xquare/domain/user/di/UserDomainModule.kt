package com.xquare.domain.user.di

import com.xquare.common.project.baseUrl
import com.xquare.domain.user.datasource.database.UserDatabaseDataSource
import com.xquare.domain.user.datasource.database.UserDatabaseDataSourceImpl
import com.xquare.domain.user.datasource.datastore.UserDataStoreDataSource
import com.xquare.domain.user.datasource.datastore.UserDataStoreDataSourceImpl
import com.xquare.domain.user.datasource.network.UserNetworkDataSource
import com.xquare.domain.user.datasource.network.UserNetworkDataSourceImpl
import com.xquare.domain.user.datasource.network.service.UserNetworkService
import com.xquare.domain.user.datasource.network.service.UserNetworkServiceImpl
import com.xquare.domain.user.repository.UserRepository
import com.xquare.domain.user.repository.UserRepositoryImpl
import com.xquare.domain.user.usecase.LoginUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val userDomainModule: Module
    get() = module {
        includes(
            dataSourceModule,
            useCaseModule,
        )

        single<UserRepository> { UserRepositoryImpl(get(), get(), get(), get(), get()) }
    }

private val dataSourceModule: Module
    get() = module {
        single<UserDatabaseDataSource> { UserDatabaseDataSourceImpl() }
        single<UserDataStoreDataSource> { UserDataStoreDataSourceImpl() }
        single<UserNetworkDataSource> { UserNetworkDataSourceImpl(get()) }

        single<UserNetworkService> {
            val baseUri = "$baseUrl/users"

            UserNetworkServiceImpl(
                httpClient = get(),
                baseUri = baseUri,
            )
        }
    }

private val useCaseModule: Module
    get() = module {
        single { LoginUseCase(get()) }
    }
