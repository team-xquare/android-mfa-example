package com.xquare.domain.user.datasource.network

import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import com.xquare.domain.user.model.output.AuthOutput

internal interface UserNetworkDataSource {
    suspend fun register(input: RegisterInput)
    suspend fun login(input: LoginInput): AuthOutput
    suspend fun reissueToken(): AuthOutput
}
