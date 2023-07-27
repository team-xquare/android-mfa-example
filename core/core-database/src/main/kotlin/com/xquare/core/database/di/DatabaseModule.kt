package com.xquare.core.database.di

import androidx.room.Room
import com.xquare.core.database.XquareDatabase
import com.xquare.core.database.datasource.MealDbDatasource
import com.xquare.core.database.datasource.MealDbDatasourceImpl
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
    single<MealDbDatasource> { MealDbDatasourceImpl(get()) }
}

private val daoModule = module {
    single { get<XquareDatabase>().mealDao() }
}
