package com.xquare.core.datastore.di

import com.xquare.core.datastore.preferencesDatastore
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

val dataStoreModule: Module
    get() = module {
        single { androidApplication().preferencesDatastore }
    }
