package com.xquare.domain.meal.repository

import com.xquare.domain.meal.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

interface MealRepository {
    suspend fun getMealByDate(date: LocalDate): Flow<Meal>
    suspend fun getMealsByYearAndMonth(year: Int, month: Int): Flow<List<Meal>>
}
