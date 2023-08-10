package com.xquare.core.datastore.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant
import java.io.IOException

internal class UserPreferencesDataSourceImpl(
	private val dataStore: DataStore<Preferences>,
) : UserPreferencesDataSource {
	override fun fetchAccessToken(): Flow<String> = dataStore.data.map { preferences ->
		preferences[PREFERENCES_KEY_ACCESS_TOKEN]
			?: throw IOException() // todo make custom exception
	}

	override suspend fun saveAccessToken(token: String) {
		dataStore.edit { preferences -> preferences[PREFERENCES_KEY_REFRESH_TOKEN] = token }
	}

	override fun fetchAccessTokenExpiration(): Flow<Instant> = dataStore.data.map { preferences ->
		val epochTime = preferences[PREFERENCES_KEY_ACCESS_TOKEN_EXPIRATION]
			?: throw IOException() // todo make custom exception
		Instant.fromEpochMilliseconds(epochTime)
	}

	override suspend fun saveAccessTokenExpiration(expiration: Instant) {
		dataStore.edit { preferences ->
			preferences[PREFERENCES_KEY_ACCESS_TOKEN_EXPIRATION] = expiration.epochSeconds
		}
	}

	override fun fetchRefreshToken(): Flow<String> = dataStore.data.map { preferences ->
		preferences[PREFERENCES_KEY_REFRESH_TOKEN]
			?: throw IOException() // todo make custom exception
	}

	override suspend fun saveRefreshToken(token: String) {
		dataStore.edit { preferences ->
			preferences[PREFERENCES_KEY_REFRESH_TOKEN] = token
		}
	}

	override fun fetchRefreshTokenExpiration(): Flow<Instant> = dataStore.data.map { preferences ->
		val epochTime = preferences[PREFERENCES_KEY_REFRESH_TOKEN_EXPIRATION]
			?: throw IOException() // todo make custom exception
		Instant.fromEpochMilliseconds(epochTime)
	}

	override suspend fun saveRefreshTokenExpiration(expiration: Instant) {
		dataStore.edit { preferences ->
			preferences[PREFERENCES_KEY_REFRESH_TOKEN_EXPIRATION] = expiration.epochSeconds
		}
	}

	companion object {
		private val PREFERENCES_KEY_ACCESS_TOKEN = stringPreferencesKey("access_token")
		private val PREFERENCES_KEY_ACCESS_TOKEN_EXPIRATION =
			longPreferencesKey("access_token_expiration")

		private val PREFERENCES_KEY_REFRESH_TOKEN = stringPreferencesKey("refresh_token")
		private val PREFERENCES_KEY_REFRESH_TOKEN_EXPIRATION =
			longPreferencesKey("refresh_token_expiration")
	}
}
