package com.xquare.core.datastore.di

import com.xquare.common.di.DiQualifier
import com.xquare.core.datastore.datasource.UserPreferencesDataSource
import com.xquare.core.datastore.datasource.UserPreferencesDataSourceImpl
import com.xquare.core.datastore.preferencesDatastore
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataStoreModule: Module
    get() = module {
        includes(
            datasourceModule,
        )
        single { androidApplication().preferencesDatastore }
        factory(named(DiQualifier.Authorization.ACCESS_TOKEN)) {
            get<UserPreferencesDataSource>().fetchAccessToken()
        }
        factory(named(DiQualifier.Authorization.ACCESS_TOKEN_EXPIRATION)) {
            get<UserPreferencesDataSource>().fetchAccessTokenExpiration()
        }
        factory(named(DiQualifier.Authorization.REFRESH_TOKEN)) {
            get<UserPreferencesDataSource>().fetchRefreshToken()
        }
        factory(named(DiQualifier.Authorization.REFRESH_TOKEN_EXPIRATION)) {
            get<UserPreferencesDataSource>().fetchRefreshTokenExpiration()
        }
    }

private val datasourceModule: Module
    get() = module {
        single<UserPreferencesDataSource> { UserPreferencesDataSourceImpl(get()) }
    }
