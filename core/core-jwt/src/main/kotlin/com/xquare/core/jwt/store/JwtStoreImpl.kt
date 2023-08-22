package com.xquare.core.jwt.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.xquare.core.jwt.Tokens
import com.xquare.core.jwt.alias.AccessToken
import com.xquare.core.jwt.alias.AccessTokenExpiration
import com.xquare.core.jwt.alias.RefreshToken
import com.xquare.core.jwt.alias.RefreshTokenExpiration
import com.xquare.core.jwt.exception.AccessTokenExpirationNotFoundException
import com.xquare.core.jwt.exception.AccessTokenNotFoundException
import com.xquare.core.jwt.exception.RefreshTokenExpirationNotFoundException
import com.xquare.core.jwt.exception.RefreshTokenNotFoundException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
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

    override suspend fun loadTokens(): Flow<Tokens> {
        val accessToken = this.loadAccessToken().first()
        val accessTokenExp = this.loadAccessTokenExpiration().first()
        val refreshToken = this.loadRefreshToken().first()
        val refreshTokenExp = this.loadRefreshTokenExpiration().first()

        // todo flow를 생성해야 하는 이유 생각해보기 - 다른 api와 통일 가능, but JwtFacade 구현 시 flow 생성 필요 없음
        return flow {
            Tokens(
                accessToken = accessToken,
                accessTokenExpiration = accessTokenExp,
                refreshToken = refreshToken,
                refreshTokenExpiration = refreshTokenExp,
            )
        }
    }

    override suspend fun storeTokens(tokens: Tokens) {
        this.storeAccessToken(tokens.accessToken)
        this.storeAccessTokenExpiration(tokens.accessTokenExpiration)
        this.storeRefreshToken(tokens.refreshToken)
        this.storeRefreshTokenExpiration(tokens.refreshTokenExpiration)
    }

    // todo (주석 제거 필요) 토큰을 일일히 지우는 메서드를 호출하는 이유 =
    override suspend fun clearTokens() {
        this.clearAccessToken()
        this.clearAccessTokenExpiration()
        this.clearRefreshToken()
        this.clearRefreshTokenExpiration()
    }

    companion object {
        private val KEY_ACCESS_TOKEN = stringPreferencesKey("access_token")
        private val KEY_ACCESS_TOKEN_EXPIRATION = longPreferencesKey("access_token_expiration")
        private val KEY_REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        private val KEY_REFRESH_TOKEN_EXPIRATION = longPreferencesKey("refresh_token_expiration")
    }
}
