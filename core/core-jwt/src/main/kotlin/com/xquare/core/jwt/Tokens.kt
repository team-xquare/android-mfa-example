package com.xquare.core.jwt

import com.xquare.core.jwt.alias.AccessToken
import com.xquare.core.jwt.alias.AccessTokenExpiration
import com.xquare.core.jwt.alias.RefreshToken
import com.xquare.core.jwt.alias.RefreshTokenExpiration

data class Tokens(
    val accessToken: AccessToken,
    val accessTokenExpiration: AccessTokenExpiration,
    val refreshToken: RefreshToken,
    val refreshTokenExpiration: RefreshTokenExpiration,
)
