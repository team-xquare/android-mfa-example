package com.xquare.domain.meal.datasource.network.apiservice

import com.xquare.domain.meal.model.Meal
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import kotlinx.datetime.LocalDate

internal class MealApiServiceImpl(
    private val httpClient: HttpClient,
    override val baseUri: String = "meals",
) : MealApiService {
    override suspend fun fetchMeal(date: LocalDate): Meal = httpClient.get {
        url { path(baseUri, date.toString()) }
    }.body()

    override suspend fun fetchMealByYearAndMonth(year: Int, month: Int): List<Meal> = httpClient.get {
        url {
            path(baseUri)
            parameters.run {
                append("year", year.toString())
                append("month", month.toString())
            }
        }
    }.body()
}
