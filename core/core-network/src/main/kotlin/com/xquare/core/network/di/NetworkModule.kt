package com.xquare.core.network.di

import com.xquare.core.network.client.httpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module
    get() = module { single { httpClient } }
