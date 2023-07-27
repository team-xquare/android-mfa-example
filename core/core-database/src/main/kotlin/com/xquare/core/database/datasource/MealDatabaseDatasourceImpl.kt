package com.xquare.core.database.datasource

import com.xquare.core.database.dao.MealDao
import com.xquare.core.database.model.MealEntity
import com.xquare.core.database.model.asDatabaseEntity
import com.xquare.core.database.model.asExternalModel
import com.xquare.core.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDate

internal class MealDatabaseDatasourceImpl(
    private val mealDao: MealDao,
) : MealDatabaseDatasource {
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
