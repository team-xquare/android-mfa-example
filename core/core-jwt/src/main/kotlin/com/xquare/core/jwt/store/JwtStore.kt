package com.xquare.core.jwt.store

import kotlinx.datetime.LocalDateTime

// todo typealias 분리
typealias Token = String
typealias Expiration = LocalDateTime

interface JwtStore {
    fun loadAccessToken(): Token
    fun storeAccessToken(token: Token)
    fun clearAccessToken()
    fun loadAccessTokenExpiration(): Expiration
    fun storeAccessTokenExpiration(expiration: Expiration)
    fun clearAccessTokenExpiration()
    fun loadRefreshToken(): Token
    fun storeRefreshToken(token: Token)
    fun clearRefreshToken()
    fun loadRefreshTokenExpiration(): Expiration
    fun storeRefreshTokenExpiration(expiration: Expiration)
    fun clearRefreshTokenExpiration()
}
