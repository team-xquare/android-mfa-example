package com.xquare.core.jwt.di

import com.xquare.common.di.DiQualifier
import com.xquare.core.jwt.store.JwtStore
import com.xquare.core.jwt.store.JwtStoreImpl
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val jwtModule: Module
    get() = module {
        single<JwtStore> { JwtStoreImpl(get()) }

        factory(qualifier = named(DiQualifier.Authorization.ACCESS_TOKEN)) {
            get<JwtStore>().loadAccessToken()
        }
        factory(qualifier = named(DiQualifier.Authorization.ACCESS_TOKEN_EXPIRATION)) {
            get<JwtStore>().loadAccessTokenExpiration()
        }
        factory(qualifier = named(DiQualifier.Authorization.REFRESH_TOKEN)) {
            get<JwtStore>().loadRefreshToken()
        }
        factory(qualifier = named(DiQualifier.Authorization.REFRESH_TOKEN_EXPIRATION)) {
            get<JwtStore>().loadRefreshTokenExpiration()
        }
    }
