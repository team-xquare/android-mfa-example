package com.xquare.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.xquare.core.database.model.MealEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.days

@Dao
internal interface MealDao {

    @Transaction
    @Query(
        """
            SELECT *
            FROM tbl_meal
            WHERE date = :date;
        """,
    )
    fun findByDate(date: Instant): Flow<MealEntity>

    @Transaction
    @Query(
        """
            SELECT * 
            FROM tbl_meal 
            WHERE date BETWEEN :from AND :to;
        """,
    )
    fun findByDateBetween(
        date: Instant,
        from: Instant = date.minus(15.days),
        to: Instant = date.plus(15.days),
    ): Flow<List<MealEntity>>

    @Transaction
    @Query(
        """
            SELECT *
            FROM tbl_meal;
        """,
    )
    fun findAll(): Flow<List<MealEntity>>

    @Transaction
    @Insert(
        onConflict = OnConflictStrategy.IGNORE,
    )
    fun save(value: MealEntity)

    @Transaction
    @Insert(
        onConflict = OnConflictStrategy.IGNORE,
    )
    fun saveAll(values: List<MealEntity>)

    @Transaction
    @Query(
        """
            DELETE FROM tbl_meal
            WHERE date = :date;
        """,
    )
    fun deleteByDate(date: Instant)
}
