package com.xquare.corenetwork.di

import com.xquare.corenetwork.interceptor.AuthorizationInterceptor
import org.koin.dsl.module

val networkModule = module {
    single { AuthorizationInterceptor() }
}
