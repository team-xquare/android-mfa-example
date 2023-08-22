package com.xquare.domain.user.datasource.network.apiservice

import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import com.xquare.domain.user.model.output.AuthOutput
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

// todo 내부 로직 재구현 필요
internal class UserApiServiceImpl(
    private val httpClient: HttpClient,
    override val baseUri: String,
) : UserApiService {
    override suspend fun register(input: RegisterInput) {
        httpClient.post { setBody(input) }
    }

    override suspend fun login(input: LoginInput): AuthOutput {
        return httpClient.post("/login") { setBody(input) }.body()
    }

    override suspend fun reissueToken(): AuthOutput {
        return httpClient.post("/login").body()
    }
}
