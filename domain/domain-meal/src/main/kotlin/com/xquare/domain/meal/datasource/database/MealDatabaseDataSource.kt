package com.xquare.domain.meal.datasource.database

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

internal interface MealDatabaseDataSource {
    fun fetchMeal(date: LocalDate): Flow<Meal>
    fun fetchMealsWithTerm(from: LocalDate, to: LocalDate): Flow<List<Meal>>
    fun fetchAllMeals(): Flow<List<Meal>>
    fun saveMeal(meal: Meal)
    fun saveAllMeals(meal: List<Meal>)
    fun deleteMealByDate(date: LocalDate)
    fun deleteAllMeals()
}
