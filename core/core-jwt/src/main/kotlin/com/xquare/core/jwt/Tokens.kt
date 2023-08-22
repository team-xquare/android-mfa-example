package com.xquare.core.jwt

import com.xquare.core.jwt.`typealias`.AccessToken
import com.xquare.core.jwt.`typealias`.AccessTokenExpiration
import com.xquare.core.jwt.`typealias`.RefreshToken
import com.xquare.core.jwt.`typealias`.RefreshTokenExpiration

data class Tokens(
    val accessToken: AccessToken,
    val accessTokenExpiration: AccessTokenExpiration,
    val refreshToken: RefreshToken,
    val refreshTokenExpiration: RefreshTokenExpiration,
)
