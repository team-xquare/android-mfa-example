package com.xquare.core.jwt.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.xquare.core.jwt.exception.AccessTokenExpirationNotFoundException
import com.xquare.core.jwt.exception.AccessTokenNotFoundException
import com.xquare.core.jwt.exception.RefreshTokenExpirationNotFoundException
import com.xquare.core.jwt.exception.RefreshTokenNotFoundException
import com.xquare.core.jwt.`typealias`.AccessToken
import com.xquare.core.jwt.`typealias`.AccessTokenExpiration
import com.xquare.core.jwt.`typealias`.RefreshToken
import com.xquare.core.jwt.`typealias`.RefreshTokenExpiration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant

internal class JwtStoreImpl(
    private val dataStore: DataStore<Preferences>,
) : JwtStore {
    override fun loadAccessToken(): Flow<AccessToken> {
        return dataStore.data.map { preferences ->
            preferences[KEY_ACCESS_TOKEN] ?: throw AccessTokenNotFoundException()
        }
    }

    override suspend fun storeAccessToken(token: AccessToken) {
        dataStore.edit { preferences ->
            preferences[KEY_ACCESS_TOKEN] = token
        }
    }

    override suspend fun clearAccessToken() {
        dataStore.edit { preferences ->
            preferences.remove(KEY_ACCESS_TOKEN)
        }
    }

    override fun loadAccessTokenExpiration(): Flow<AccessTokenExpiration> {
        return dataStore.data.map { preferences ->
            val epochTime = preferences[KEY_ACCESS_TOKEN_EXPIRATION]
                ?: throw AccessTokenExpirationNotFoundException()
            Instant.fromEpochMilliseconds(epochTime)
        }
    }

    override suspend fun storeAccessTokenExpiration(expiration: AccessTokenExpiration) {
        dataStore.edit { preferences ->
            preferences[KEY_ACCESS_TOKEN_EXPIRATION] = expiration.epochSeconds
        }
    }

    override suspend fun clearAccessTokenExpiration() {
        dataStore.edit { preferences ->
            preferences.remove(KEY_ACCESS_TOKEN_EXPIRATION)
        }
    }

    override fun loadRefreshToken(): Flow<RefreshToken> {
        return dataStore.data.map { preferences ->
            preferences[KEY_REFRESH_TOKEN] ?: throw RefreshTokenNotFoundException()
        }
    }

    override suspend fun storeRefreshToken(token: RefreshToken) {
        dataStore.edit { preferences ->
            preferences[KEY_REFRESH_TOKEN] = token
        }
    }

    override suspend fun clearRefreshToken() {
        dataStore.edit { preferences ->
            preferences.remove(KEY_REFRESH_TOKEN)
        }
    }

    override fun loadRefreshTokenExpiration(): Flow<RefreshTokenExpiration> {
        return dataStore.data.map { preferences ->
            val epochTime = preferences[KEY_REFRESH_TOKEN_EXPIRATION]
                ?: throw RefreshTokenExpirationNotFoundException()
            Instant.fromEpochMilliseconds(epochTime)
        }
    }

    override suspend fun storeRefreshTokenExpiration(expiration: RefreshTokenExpiration) {
        dataStore.edit { preferences ->
            preferences[KEY_REFRESH_TOKEN_EXPIRATION] = expiration.epochSeconds
        }
    }

    override suspend fun clearRefreshTokenExpiration() {
        dataStore.edit { preferences ->
            preferences.remove(KEY_REFRESH_TOKEN_EXPIRATION)
        }
    }

    companion object {
        private val KEY_ACCESS_TOKEN = stringPreferencesKey("access_token")
        private val KEY_ACCESS_TOKEN_EXPIRATION = longPreferencesKey("access_token_expiration")
        private val KEY_REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        private val KEY_REFRESH_TOKEN_EXPIRATION = longPreferencesKey("refresh_token_expiration")
    }
}
