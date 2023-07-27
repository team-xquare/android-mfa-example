package com.xquare.core.network.apiservice

import com.xquare.core.network.base.BaseApiService
import com.xquare.core.network.model.MealResponse
import kotlinx.datetime.LocalDate

internal interface MealApiService : BaseApiService {
    suspend fun fetchMeal(date: LocalDate): MealResponse
    suspend fun fetchMealOfMonth(date: LocalDate): List<MealResponse>
}
