package com.xquare.core.database.datasource

import com.xquare.core.database.dao.MealDao
import com.xquare.core.database.model.MealEntity
import com.xquare.core.database.model.asDatabaseEntity
import com.xquare.core.database.model.asExternalModel
import com.xquare.core.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant

internal class MealDatasourceImpl(
    private val mealDao: MealDao,
) : MealDatasource {
    override fun fetchMeal(date: Instant): Flow<Meal> =
        mealDao.findByDate(date).map(MealEntity::asExternalModel)

    override fun fetchMealsWithTerm(from: Instant, to: Instant): Flow<List<Meal>> =
        mealDao.findByDateBetween(from, to).map { it.map(MealEntity::asExternalModel) }

    override fun fetchAllMeals(): Flow<List<Meal>> =
        mealDao.findAll().map { it.map(MealEntity::asExternalModel) }

    override fun saveMeal(meal: Meal) = mealDao.save(meal.asDatabaseEntity())

    override fun saveAllMeals(meal: List<Meal>) = mealDao.saveAll(meal.map(Meal::asDatabaseEntity))

    override fun deleteMealByDate(date: Instant) = mealDao.deleteByDate(date)

    override fun deleteAllMeals() = mealDao.deleteAll()
}