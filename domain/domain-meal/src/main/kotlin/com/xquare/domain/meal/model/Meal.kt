package com.xquare.domain.meal.model

import com.xquare.core.database.model.MealEntity
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    @SerialName("date") val date: LocalDate,
    @SerialName("breakfast") val breakfast: List<String>,
    @SerialName("breakfast_kcal") val kcalOfBreakfast: String,
    @SerialName("lunch") val lunch: List<String>,
    @SerialName("lunch_kcal") val kcalOfLunch: String,
    @SerialName("dinner") val dinner: List<String>,
    @SerialName("dinner_kcal") val kcalOfDinner: String,
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
