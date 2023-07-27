package com.xquare.core.network.apiservice

import com.xquare.core.network.model.MealResponse
import io.ktor.client.HttpClient
import kotlinx.datetime.LocalDate

internal class MealApiServiceImpl(
    private val httpClient: HttpClient,
) : MealApiService {
    override suspend fun fetchMeal(date: LocalDate): MealResponse {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMealOfMonth(date: LocalDate): List<MealResponse> {
        TODO("Not yet implemented")
    }
}
