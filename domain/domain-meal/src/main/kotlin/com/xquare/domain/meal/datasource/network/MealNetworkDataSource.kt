package com.xquare.domain.meal.datasource.network

import com.xquare.domain.meal.model.Meal
import kotlinx.datetime.LocalDate

internal interface MealNetworkDataSource {
    suspend fun fetchMeal(date: LocalDate): Meal
    suspend fun fetchMealOfMonth(date: LocalDate): List<Meal>
}
