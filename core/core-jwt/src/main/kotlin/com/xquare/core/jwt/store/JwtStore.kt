package com.xquare.core.jwt.store

import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime

// todo typealias 분리
typealias Token = String
typealias Expiration = LocalDateTime

interface JwtStore {
    fun loadAccessToken(): Flow<Token>
    fun storeAccessToken(token: Token)
    fun clearAccessToken()
    fun loadAccessTokenExpiration(): Flow<Expiration>
    fun storeAccessTokenExpiration(expiration: Expiration)
    fun clearAccessTokenExpiration()
    fun loadRefreshToken(): Flow<Token>
    fun storeRefreshToken(token: Token)
    fun clearRefreshToken()
    fun loadRefreshTokenExpiration(): Flow<Expiration>
    fun storeRefreshTokenExpiration(expiration: Expiration)
    fun clearRefreshTokenExpiration()
}
