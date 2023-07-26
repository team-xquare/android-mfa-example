package com.xquare.core.database.di

import androidx.room.Room
import com.xquare.core.database.XquareDatabase
import com.xquare.core.database.datasource.MealDatasource
import com.xquare.core.database.datasource.MealDatasourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
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

private val datasourceModule = module {
    single<MealDatasource> { MealDatasourceImpl(get()) }
}

private val daoModule = module {
    single { get<XquareDatabase>().mealDao() }
}
