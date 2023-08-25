package com.xquare.domain.meal.datasource.network.service

import com.xquare.core.network.base.BaseApiService
import com.xquare.domain.meal.model.Meal
import kotlinx.datetime.LocalDate

internal interface MealNetworkService : BaseApiService {
    suspend fun fetchMeal(date: LocalDate): Meal
    suspend fun fetchMealByYearAndMonth(year: Int, month: Int): List<Meal>
}
