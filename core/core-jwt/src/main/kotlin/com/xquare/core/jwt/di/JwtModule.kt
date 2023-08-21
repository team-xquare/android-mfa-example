package com.xquare.core.jwt.di

import com.xquare.core.jwt.store.JwtStore
import com.xquare.core.jwt.store.JwtStoreImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val jwtModule: Module
    get() = module {
        single<JwtStore> { JwtStoreImpl(get()) }
    }
