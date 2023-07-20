package com.xquare.network.di

import com.xquare.network.interceptor.AuthorizationInterceptor
import org.koin.dsl.module

val networkModule = module {
    single { AuthorizationInterceptor() }
}
