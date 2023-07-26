package com.xquare.core.database.di

import androidx.room.Room
import com.xquare.core.database.XquareDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = XquareDatabase::class.java,
            name = "database-xquare",
        ).build()
    }
}
