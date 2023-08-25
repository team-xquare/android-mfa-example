package com.xquare.domain.meal.datasource.datastore.service

import androidx.datastore.core.DataStore
import java.util.prefs.Preferences

internal class MealDataStoreServiceImpl(
    private val dataStore: DataStore<Preferences>,
) : MealDataStoreService