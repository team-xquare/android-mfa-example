package com.xquare.domain.user.usecase

import com.xquare.core.jwt.Tokens
import com.xquare.core.jwt.store.JwtStore
import com.xquare.core.role.Role
import com.xquare.core.role.store.RoleStore
import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.repository.UserRepository
import kotlinx.datetime.toInstant

class LoginUseCase(
    private val userRepository: UserRepository,
    private val jwtStore: JwtStore,
    private val roleStore: RoleStore,
) {
    suspend operator fun invoke(input: LoginInput) {
        val output = userRepository.login(input)

        // todo converter 적용
        val tokens = Tokens(
            accessToken = output.accessToken,
            output.accessTokenExpiration.toInstant(),
            output.refreshToken,
            output.refreshTokenExpiration.toInstant(),
        )
        val role = Role.valueOf(output.role)

        jwtStore.storeTokens(tokens)
        roleStore.storeRole(role)
    }
}
