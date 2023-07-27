package com.xquare.core.database.di

import androidx.room.Room
import com.xquare.core.database.XquareDatabase
import com.xquare.core.database.datasource.MealDatabaseDatasource
import com.xquare.core.database.datasource.MealDatabaseDatasourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module
    get() = module {
        includes(
            datasourceModule,
            daoModule,
        )
        single {
            Room.databaseBuilder(
                context = androidApplication(),
                klass = XquareDatabase::class.java,
                name = "database-xquare",
            ).build()
        }
    }

private val datasourceModule: Module
    get() = module {
        single<MealDatabaseDatasource> { MealDatabaseDatasourceImpl(get()) }
    }

private val daoModule: Module
    get() = module {
        single { get<XquareDatabase>().mealDao() }
    }
