package com.xquare.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xquare.core.database.dao.MealDao
import com.xquare.core.database.model.MealEntity
import com.xquare.core.database.util.InstantConverter

@Database(
    entities = [
        MealEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    InstantConverter::class,
)
internal abstract class XquareDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}
