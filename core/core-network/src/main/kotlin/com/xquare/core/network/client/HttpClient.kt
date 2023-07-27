package com.xquare.core.network.client

import com.xquare.core.common.util.isDebugEnabled
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json

internal val httpClient = HttpClient(CIO) {
    expectSuccess = true

    install(ContentNegotiation) { json() }
    if (isDebugEnabled) {
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.BODY
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }
    defaultRequest {
        url(
            urlString = if (isDebugEnabled) {
                STAG_BASE_URL
            } else {
                PROD_BASE_URL
            },
        )
    }
}

private const val PROD_BASE_URL = "https://api.xquare.app"
private const val STAG_BASE_URL = "https://stag-api.xquare.app"
