package com.xquare.domain.user.datasource.network.service

import com.xquare.core.network.base.BaseApiService
import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import com.xquare.domain.user.model.output.AuthOutput

internal interface UserNetworkService : BaseApiService {
    suspend fun register(input: RegisterInput)
    suspend fun login(input: LoginInput): AuthOutput
    suspend fun reissueToken(): AuthOutput
}
