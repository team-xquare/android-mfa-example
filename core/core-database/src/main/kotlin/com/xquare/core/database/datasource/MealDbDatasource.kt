package com.xquare.core.database.datasource

import com.xquare.core.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

interface MealDbDatasource {
    fun fetchMeal(date: LocalDate): Flow<Meal>
    fun fetchMealsWithTerm(from: LocalDate, to: LocalDate): Flow<List<Meal>>
    fun fetchAllMeals(): Flow<List<Meal>>
    fun saveMeal(meal: Meal)
    fun saveAllMeals(meal: List<Meal>)
    fun deleteMealByDate(date: LocalDate)
    fun deleteAllMeals()
}
