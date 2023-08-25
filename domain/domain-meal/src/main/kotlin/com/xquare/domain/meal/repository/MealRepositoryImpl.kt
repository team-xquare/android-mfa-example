package com.xquare.domain.meal.repository

import com.xquare.domain.meal.datasource.database.MealDatabaseDataSource
import com.xquare.domain.meal.datasource.datastore.MealDataStoreDataSource
import com.xquare.domain.meal.datasource.network.MealNetworkDataSource
import com.xquare.domain.meal.exception.DatabaseMealNotFoundException
import com.xquare.domain.meal.exception.MealNotFoundException
import com.xquare.domain.meal.exception.NetworkMealNotFoundException
import com.xquare.domain.meal.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.LocalDate

internal class MealRepositoryImpl(
    private val mealDatabaseDataSource: MealDatabaseDataSource,
    private val mealDataStoreDataSource: MealDataStoreDataSource,
    private val mealNetworkDataSource: MealNetworkDataSource,
    private val jwtStore: JwtStore,
    private val roleStore: RoleStore,
) : MealRepository {

    override suspend fun getMealByDate(date: LocalDate): Flow<Meal> {
        // todo try catch 로직 수정
        return try {
            this.fetchMealFromDatabaseByDate(date)
        } catch (e: DatabaseMealNotFoundException) {
            // todo flow 로직 수정
            flow {
                val meal = fetchMealFromNetworkByDate(date)
                mealDatabaseDataSource.saveMeal(meal)
                emit(meal)
            }
        } catch (e: NetworkMealNotFoundException) {
            throw MealNotFoundException()
        }
    }

    override suspend fun getMealsByYearAndMonth(year: Int, month: Int): Flow<List<Meal>> {
        // todo try catch 로직 수정
        return try {
            this.fetchMealsFromDatabaseByYearAndMonth(year, month)
        } catch (e: DatabaseMealNotFoundException) {
            // todo flow 로직 수정
            flow {
                val meals = fetchMealsFromNetworkByYearAndMonth(year, month)
                mealDatabaseDataSource.saveAllMeals(meals)
                emit(meals)
            }
        } catch (e: NetworkMealNotFoundException) {
            throw MealNotFoundException()
        }
    }

    private fun fetchMealFromDatabaseByDate(date: LocalDate): Flow<Meal> =
        mealDatabaseDataSource.queryMealByDate(date)

    private suspend fun fetchMealFromNetworkByDate(date: LocalDate): Meal =
        mealNetworkDataSource.fetchMeal(date)

    private fun fetchMealsFromDatabaseByYearAndMonth(year: Int, month: Int): Flow<List<Meal>> =
        mealDatabaseDataSource.queryMealsByYearAndMonth(year, month)

    private suspend fun fetchMealsFromNetworkByYearAndMonth(year: Int, month: Int): List<Meal> =
        mealNetworkDataSource.fetchMealsByYearAndMonth(year, month)
}
