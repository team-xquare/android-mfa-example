package com.xquare.core.jwt

import com.xquare.common.di.DiQualifier
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.get

// todo di 패키지 또는 모듈로 이동
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
