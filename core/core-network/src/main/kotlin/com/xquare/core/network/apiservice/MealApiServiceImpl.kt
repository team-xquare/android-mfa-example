package com.xquare.core.network.apiservice

import com.xquare.core.network.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import kotlinx.datetime.LocalDate

internal class MealApiServiceImpl(
    private val httpClient: HttpClient,
    override val baseUri: String = "meals",
) : MealApiService {
    override suspend fun fetchMeal(date: LocalDate): MealResponse = httpClient.get {
        url { path(baseUri, date.toString()) }
    }.body()

    override suspend fun fetchMealOfMonth(date: LocalDate): List<MealResponse> = httpClient.get {
        url {
            path(baseUri)
            parameters.run {
                append("year", date.year.toString())
                append("month", date.monthNumber.toString())
            }
        }
    }.body()
}
