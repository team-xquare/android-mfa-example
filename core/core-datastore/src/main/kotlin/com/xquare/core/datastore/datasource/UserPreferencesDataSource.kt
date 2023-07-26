package com.xquare.core.datastore.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Instant

interface UserPreferencesDataSource {

    fun fetchAccessToken(): Flow<String>
    suspend fun saveAccessToken(token: String)
    fun fetchAccessTokenExpiration(): Flow<Instant>
    suspend fun saveAccessTokenExpiration(expiration: Instant)

    fun fetchRefreshToken(): Flow<String>
    suspend fun saveRefreshToken(token: String)
    fun fetchRefreshTokenExpiration(): Flow<Instant>
    suspend fun saveRefreshTokenExpiration(expiration: Instant)
}
