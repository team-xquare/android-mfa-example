package com.xquare.domain.user.repository

import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput

interface UserRepository {
    suspend fun register(input: RegisterInput)
    suspend fun login(input: LoginInput)
}
