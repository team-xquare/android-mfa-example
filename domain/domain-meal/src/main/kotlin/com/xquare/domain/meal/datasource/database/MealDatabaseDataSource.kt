package com.xquare.domain.meal.datasource.database

import com.xquare.domain.meal.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

internal interface MealDatabaseDataSource {
    fun queryMealByDate(date: LocalDate): Flow<Meal>
    fun queryMealsByYearAndMonth(year: Int, month: Int): Flow<List<Meal>>
    fun queryMealsBetween(from: LocalDate, to: LocalDate): Flow<List<Meal>>
    fun queryAllMeals(): Flow<List<Meal>>
    fun saveMeal(meal: Meal)
    fun saveAllMeals(meal: List<Meal>)
    fun deleteMealByDate(date: LocalDate)
    fun deleteMealsByYearAndMonth(year: Int, month: Int)
    fun deleteMealsBetween(from: LocalDate, to: LocalDate)
    fun deleteAllMeals()
}
