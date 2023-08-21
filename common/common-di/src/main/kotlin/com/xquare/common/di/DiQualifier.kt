package com.xquare.common.di

object DiQualifier {
    object Authorization {
        const val ACCESS_TOKEN = "access_token"
        const val ACCESS_TOKEN_EXPIRATION = "access_token_expiration"
        const val REFRESH_TOKEN = "refresh_token"
        const val REFRESH_TOKEN_EXPIRATION = "refresh_token_expiration"
    }

    object Build {
        const val DEBUG = "debug"
    }

    object Http {
        const val BASE_URL = "base_url"
    }
}
