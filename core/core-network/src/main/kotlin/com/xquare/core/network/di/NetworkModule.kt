package com.xquare.core.network.di

import com.xquare.core.network.datasource.UserDataSource
import com.xquare.core.network.datasource.UserDataSourceImpl
import com.xquare.core.network.interceptor.AuthorizationInterceptor
import org.koin.dsl.module

val networkModule = module {
    includes(dataSourceModule)
    single { AuthorizationInterceptor() }
}

private val dataSourceModule = module {
    single<UserDataSource> { UserDataSourceImpl() }
}
