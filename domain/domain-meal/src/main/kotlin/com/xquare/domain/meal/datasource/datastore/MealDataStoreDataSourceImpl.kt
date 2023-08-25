package com.xquare.domain.meal.datasource.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

internal class MealDataStoreDataSourceImpl(
    private val dataStore: DataStore<Preferences>,
) : MealDataStoreDataSource
