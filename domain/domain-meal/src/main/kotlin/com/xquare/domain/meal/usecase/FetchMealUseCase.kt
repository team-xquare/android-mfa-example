package com.xquare.domain.meal.usecase

import com.xquare.domain.meal.model.Meal
import com.xquare.domain.meal.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

class FetchMealUseCase(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(date: LocalDate): Flow<Meal> =
        mealRepository.getMealByDate(date)
}
