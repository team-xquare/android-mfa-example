package com.xquare.core.data.model

import kotlinx.datetime.Instant

data class Meal(
    val date: Instant,
    val breakfast: List<String>,
    val kcalOfBreakfast: String,
    val lunch: List<String>,
    val kcalOfLunch: String,
    val dinner: List<String>,
    val kcalOfDinner: String,
)
