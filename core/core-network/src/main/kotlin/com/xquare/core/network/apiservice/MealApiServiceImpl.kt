package com.xquare.core.network.apiservice

import com.xquare.core.network.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.datetime.LocalDate

internal class MealApiServiceImpl(
    private val httpClient: HttpClient,
) : MealApiService {
    override suspend fun fetchMeal(date: LocalDate): MealResponse = httpClient.get("/meals") {
        url { parameters.append("date", date.toString()) }
    }.body()

    override suspend fun fetchMealOfMonth(date: LocalDate): List<MealResponse> =
        httpClient.get("/meals") {
            url {
                parameters.run {
                    append("year", date.year.toString())
                    append("month", date.monthNumber.toString())
                }
            }
        }.body()
}
