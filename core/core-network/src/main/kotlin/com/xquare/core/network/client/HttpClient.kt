package com.xquare.core.network.client

import android.util.Log
import com.xquare.core.common.di.DiQualifier
import com.xquare.core.common.util.isDebugEnabled
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.get

internal val httpClient = HttpClient(CIO) {
    expectSuccess = true

    install(ContentNegotiation) { json() }
    if (isDebugEnabled) {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.w("HTTP", message)
                }
            }
            level = LogLevel.BODY
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }
    defaultRequest {
        contentType(ContentType.Application.Json)
        url(
            urlString = get(
                clazz = String::class.java,
                qualifier = named(DiQualifier.Http.BASE_URL),
            )
        )
    }
}
