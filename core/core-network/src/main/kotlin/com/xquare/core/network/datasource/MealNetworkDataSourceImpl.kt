package com.xquare.core.network.datasource

import com.xquare.core.model.Meal
import com.xquare.core.network.apiservice.MealApiService
import com.xquare.core.network.model.MealResponse
import com.xquare.core.network.model.asExternalModel
import kotlinx.datetime.LocalDate

internal class MealNetworkDataSourceImpl(
    private val mealApiService: MealApiService,
) : MealNetworkDataSource {
    override suspend fun fetchMeal(date: LocalDate): Meal =
        mealApiService.fetchMeal(date).asExternalModel()

    override suspend fun fetchMealOfMonth(date: LocalDate): List<Meal> =
        mealApiService.fetchMealOfMonth(date).map(MealResponse::asExternalModel)
}
