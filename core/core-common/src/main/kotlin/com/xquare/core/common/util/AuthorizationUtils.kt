package com.xquare.core.common.util

import com.xquare.core.common.di.DiQualifier
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.get

val accessToken: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.ACCESS_TOKEN),
    )

val accessTokenExpiration: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.ACCESS_TOKEN_EXPIRATION),
    )

val refreshToken: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.REFRESH_TOKEN),
    )

val refreshTokenExpiration: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.REFRESH_TOKEN_EXPIRATION),
    )
