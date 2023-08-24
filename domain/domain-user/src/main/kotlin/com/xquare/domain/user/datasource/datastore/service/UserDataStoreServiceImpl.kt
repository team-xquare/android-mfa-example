package com.xquare.domain.user.datasource.datastore.service

import androidx.datastore.core.DataStore
import java.util.prefs.Preferences

internal class UserDataStoreServiceImpl(
    private val dataStore: DataStore<Preferences>,
) : UserDataStoreService
