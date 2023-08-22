package com.xquare.core.jwt.store

import com.xquare.core.jwt.`typealias`.AccessToken
import com.xquare.core.jwt.`typealias`.AccessTokenExpiration
import com.xquare.core.jwt.`typealias`.RefreshToken
import com.xquare.core.jwt.`typealias`.RefreshTokenExpiration
import kotlinx.coroutines.flow.Flow

interface JwtStore {
    fun loadAccessToken(): Flow<AccessToken>
    suspend fun storeAccessToken(token: AccessToken)
    suspend fun clearAccessToken()
    fun loadAccessTokenExpiration(): Flow<AccessTokenExpiration>
    suspend fun storeAccessTokenExpiration(expiration: AccessTokenExpiration)
    suspend fun clearAccessTokenExpiration()
    fun loadRefreshToken(): Flow<RefreshToken>
    suspend fun storeRefreshToken(token: RefreshToken)
    suspend fun clearRefreshToken()
    fun loadRefreshTokenExpiration(): Flow<RefreshTokenExpiration>
    suspend fun storeRefreshTokenExpiration(expiration: RefreshTokenExpiration)
    suspend fun clearRefreshTokenExpiration()
}
