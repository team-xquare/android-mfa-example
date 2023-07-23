package com.xquare.core.network.di

import com.xquare.core.network.interceptor.AuthorizationInterceptor
import org.koin.dsl.module

val networkModule = module {
    single { AuthorizationInterceptor() }
}
