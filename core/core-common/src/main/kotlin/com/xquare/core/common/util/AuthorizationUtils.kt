package com.xquare.core.common.util

import com.xquare.core.common.di.DiQualifier
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.get

internal val accessToken: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.ACCESS_TOKEN),
    )

internal val accessTokenExpiration: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.ACCESS_TOKEN_EXPIRATION),
    )

internal val refreshToken: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.REFRESH_TOKEN),
    )

internal val refreshTokenExpiration: String
    inline get() = get(
        clazz = String::class.java,
        qualifier = named(DiQualifier.Authorization.REFRESH_TOKEN_EXPIRATION),
    )
