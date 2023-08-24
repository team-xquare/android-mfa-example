package com.xquare.domain.meal.datasource.network

import com.xquare.domain.meal.datasource.network.apiservice.MealApiService
import com.xquare.domain.meal.model.Meal
import kotlinx.datetime.LocalDate

internal class MealNetworkDataSourceImpl(
    private val mealApiService: MealApiService,
) : MealNetworkDataSource {
    override suspend fun fetchMeal(date: LocalDate): Meal =
        mealApiService.fetchMeal(date)

    override suspend fun fetchMealsByYearAndMonth(year: Int, month: Int): List<Meal> =
        mealApiService.fetchMealByYearAndMonth(year, month)
}
