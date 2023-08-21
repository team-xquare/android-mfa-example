package com.xquare.domain.meal.datasource.database

import com.xquare.core.database.dao.MealDao
import com.xquare.core.database.model.MealEntity
import com.xquare.domain.meal.model.Meal
import com.xquare.domain.meal.model.asDatabaseEntity
import com.xquare.domain.meal.model.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDate

internal class MealDatabaseDataSourceImpl(
    private val mealDao: MealDao,
) : MealDatabaseDataSource {
    override fun fetchMeal(date: LocalDate): Flow<Meal> =
        mealDao.findByDate(date).map(MealEntity::asExternalModel)

    override fun fetchMealsWithTerm(from: LocalDate, to: LocalDate): Flow<List<Meal>> =
        mealDao.findByDateBetween(from, to).map { it.map(MealEntity::asExternalModel) }

    override fun fetchAllMeals(): Flow<List<Meal>> =
        mealDao.findAll().map { it.map(MealEntity::asExternalModel) }

    override fun saveMeal(meal: Meal) = mealDao.save(meal.asDatabaseEntity())

    override fun saveAllMeals(meal: List<Meal>) = mealDao.saveAll(meal.map(Meal::asDatabaseEntity))

    override fun deleteMealByDate(date: LocalDate) = mealDao.deleteByDate(date)

    override fun deleteAllMeals() = mealDao.deleteAll()
}
