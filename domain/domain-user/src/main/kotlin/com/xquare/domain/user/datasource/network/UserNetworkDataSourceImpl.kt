package com.xquare.domain.user.datasource.network

import com.xquare.domain.user.datasource.network.service.UserNetworkService
import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import com.xquare.domain.user.model.output.AuthOutput

internal class UserNetworkDataSourceImpl(
    private val userNetworkService: UserNetworkService,
) : UserNetworkDataSource {
    override suspend fun register(input: RegisterInput) {
        userNetworkService.register(input)
    }

    override suspend fun login(input: LoginInput): AuthOutput {
        return userNetworkService.login(input)
    }

    override suspend fun reissueToken(): AuthOutput {
        return userNetworkService.reissueToken()
    }
}
