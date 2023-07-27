package com.xquare.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xquare.core.model.Meal
import kotlinx.datetime.Instant

@Entity(tableName = "tbl_meal")
internal data class MealEntity(

    @PrimaryKey @ColumnInfo(name = "date") val date: Instant,
    @ColumnInfo(name = "breakfast") val breakfast: List<String>,
    @ColumnInfo(name = "kcal_breakfast") val kcalOfBreakfast: String,
    @ColumnInfo(name = "lunch") val lunch: List<String>,
    @ColumnInfo(name = "kcal_lunch") val kcalOfLunch: String,
    @ColumnInfo(name = "dinner") val dinner: List<String>,
    @ColumnInfo(name = "kcal_dinner") val kcalOfDinner: String,
)

internal fun Meal.asDatabaseEntity() = MealEntity(
    date = this.date,
    breakfast = this.breakfast,
    kcalOfBreakfast = this.kcalOfBreakfast,
    lunch = this.lunch,
    kcalOfLunch = this.kcalOfLunch,
    dinner = this.dinner,
    kcalOfDinner = this.kcalOfDinner,
)

internal fun MealEntity.asExternalModel() = Meal(
    date = this.date,
    breakfast = this.breakfast,
    kcalOfBreakfast = this.kcalOfBreakfast,
    lunch = this.lunch,
    kcalOfLunch = this.kcalOfLunch,
    dinner = this.dinner,
    kcalOfDinner = this.kcalOfDinner,
)
