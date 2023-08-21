package com.xquare.domain.meal.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Meal(
    @SerialName("date") val date: LocalDate,
    @SerialName("breakfast") val breakfast: List<String>,
    @SerialName("breakfast_kcal") val kcalOfBreakfast: String,
    @SerialName("lunch") val lunch: List<String>,
    @SerialName("lunch_kcal") val kcalOfLunch: String,
    @SerialName("dinner") val dinner: List<String>,
    @SerialName("dinner_kcal") val kcalOfDinner: String,
)
