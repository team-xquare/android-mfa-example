package com.xquare.core.network.datasource

import com.xquare.core.model.Meal
import kotlinx.datetime.LocalDate

interface MealNetworkDataSource {
    suspend fun fetchMeal(date: LocalDate): Meal
    suspend fun fetchMealOfMonth(date: LocalDate): List<Meal>
}
