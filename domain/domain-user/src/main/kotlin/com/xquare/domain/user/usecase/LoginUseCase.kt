package com.xquare.domain.user.usecase

import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.repository.UserRepository

class LoginUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(input: LoginInput) {
        userRepository.login(input)
    }
}
