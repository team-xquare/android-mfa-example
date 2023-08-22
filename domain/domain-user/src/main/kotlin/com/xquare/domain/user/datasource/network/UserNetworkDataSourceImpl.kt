package com.xquare.domain.user.datasource.network

import com.xquare.domain.user.datasource.network.apiservice.UserApiService
import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import com.xquare.domain.user.model.output.AuthOutput

internal class UserNetworkDataSourceImpl(
    private val userApiService: UserApiService,
) : UserNetworkDataSource {
    override suspend fun register(input: RegisterInput) {
        userApiService.register(input)
    }

    override suspend fun login(input: LoginInput): AuthOutput {
        return userApiService.login(input)
    }

    override suspend fun reissueToken(): AuthOutput {
        return userApiService.reissueToken()
    }
}
