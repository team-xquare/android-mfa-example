package com.xquare.core.jwt.store

import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Instant

// todo typealias 분리
typealias Token = String
typealias Expiration = Instant

interface JwtStore {
    fun loadAccessToken(): Flow<Token>
    suspend fun storeAccessToken(token: Token)
    suspend fun clearAccessToken()
    fun loadAccessTokenExpiration(): Flow<Expiration>
    suspend fun storeAccessTokenExpiration(expiration: Expiration)
    suspend fun clearAccessTokenExpiration()
    fun loadRefreshToken(): Flow<Token>
    suspend fun storeRefreshToken(token: Token)
    suspend fun clearRefreshToken()
    fun loadRefreshTokenExpiration(): Flow<Expiration>
    suspend fun storeRefreshTokenExpiration(expiration: Expiration)
    suspend fun clearRefreshTokenExpiration()
}
