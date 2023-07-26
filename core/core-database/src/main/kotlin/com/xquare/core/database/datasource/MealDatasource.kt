package com.xquare.core.database.datasource

import com.xquare.core.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Instant

interface MealDatasource {
    fun fetchMeal(date: Instant): Flow<Meal>
    fun fetchMealsWithTerm(from: Instant, to: Instant): Flow<List<Meal>>
    fun fetchAllMeals(): Flow<List<Meal>>
    fun saveMeal(meal: Meal)
    fun saveAllMeals(meal: List<Meal>)
    fun deleteMealByDate(date: Instant)
    fun deleteAllMeals()
}
