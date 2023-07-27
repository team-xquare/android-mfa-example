package com.xquare.core.network.model

import com.xquare.core.model.Meal
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MealResponse(
    @SerialName("date") val date: LocalDate,
    @SerialName("breakfast") val breakfast: List<String>,
    @SerialName("breakfast_kcal") val kcalOfBreakfast: String,
    @SerialName("lunch") val lunch: List<String>,
    @SerialName("lunch_kcal") val kcalOfLunch: String,
    @SerialName("dinner") val dinner: List<String>,
    @SerialName("dinner_kcal") val kcalOfDinner: String,
)

internal fun Meal.asResponse() = MealResponse(
    date = this.date,
    breakfast = this.breakfast,
    kcalOfBreakfast = this.kcalOfBreakfast,
    lunch = this.lunch,
    kcalOfLunch = this.kcalOfLunch,
    dinner = this.dinner,
    kcalOfDinner = this.kcalOfDinner,
)

internal fun MealResponse.asExternalModel() = Meal(
    date = this.date,
    breakfast = this.breakfast,
    kcalOfBreakfast = this.kcalOfBreakfast,
    lunch = this.lunch,
    kcalOfLunch = this.kcalOfLunch,
    dinner = this.dinner,
    kcalOfDinner = this.kcalOfDinner,
)
