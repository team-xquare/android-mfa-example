package com.xquare.core.database.di

import androidx.room.Room
import com.xquare.core.database.XquareDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module
    get() = module {
        // todo 분리 고민
        includes(daoModule)
        single {
            Room.databaseBuilder(
                context = androidApplication(),
                klass = XquareDatabase::class.java,
                name = "database-xquare",
            ).build()
        }
    }

// todo 분리 고민
private val daoModule: Module
    get() = module {
        single { get<XquareDatabase>().mealDao() }
    }
