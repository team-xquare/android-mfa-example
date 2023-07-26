package com.xquare.core.datastore.di

import com.xquare.core.datastore.datasource.UserPreferencesDataSource
import com.xquare.core.datastore.datasource.UserPreferencesDataSourceImpl
import com.xquare.core.datastore.preferencesDatastore
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataStoreModule = module {
    includes(
        preferencesDatasourceModule,
    )
    single { androidApplication().preferencesDatastore }
}

private val preferencesDatasourceModule = module {
    single<UserPreferencesDataSource> { UserPreferencesDataSourceImpl(get()) }
}
