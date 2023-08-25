package com.xquare.domain.meal.datasource.network

import com.xquare.domain.meal.datasource.network.service.MealNetworkService
import com.xquare.domain.meal.model.Meal
import kotlinx.datetime.LocalDate

internal class MealNetworkDataSourceImpl(
    private val mealNetworkService: MealNetworkService,
) : MealNetworkDataSource {
    override suspend fun fetchMeal(date: LocalDate): Meal =
        mealNetworkService.fetchMeal(date)

    override suspend fun fetchMealsByYearAndMonth(year: Int, month: Int): List<Meal> =
        mealNetworkService.fetchMealByYearAndMonth(year, month)
}
