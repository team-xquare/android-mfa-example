package com.xquare.domain.user.di

import com.xquare.domain.user.datasource.database.UserDatabaseDataSource
import com.xquare.domain.user.datasource.database.UserDatabaseDataSourceImpl
import com.xquare.domain.user.datasource.datastore.UserDataStoreDataSource
import com.xquare.domain.user.datasource.datastore.UserDataStoreDataSourceImpl
import com.xquare.domain.user.datasource.network.UserNetworkDataSource
import com.xquare.domain.user.datasource.network.UserNetworkDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val userDomainModule: Module
    get() = module {
        single<UserDatabaseDataSource> { UserDatabaseDataSourceImpl() }
        single<UserDataStoreDataSource> { UserDataStoreDataSourceImpl() }
        single<UserNetworkDataSource> { UserNetworkDataSourceImpl() }
    }
