package com.xquare.domain.user.repository

import com.xquare.core.jwt.Tokens
import com.xquare.core.jwt.store.JwtStore
import com.xquare.core.role.Role
import com.xquare.core.role.store.RoleStore
import com.xquare.domain.user.datasource.database.UserDatabaseDataSource
import com.xquare.domain.user.datasource.datastore.UserDataStoreDataSource
import com.xquare.domain.user.datasource.network.UserNetworkDataSource
import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import kotlinx.datetime.toInstant

internal class UserRepositoryImpl(
    private val userDatabaseDataSource: UserDatabaseDataSource,
    private val userDataStoreDataSource: UserDataStoreDataSource,
    private val userNetworkDataSource: UserNetworkDataSource,
    private val jwtStore: JwtStore,
    private val roleStore: RoleStore,
) : UserRepository {
    override suspend fun register(input: RegisterInput) {
        userNetworkDataSource.register(input)
    }

    override suspend fun login(input: LoginInput) {
        val authOutput = userNetworkDataSource.login(input)
        // fixme network type converter 구현 후 코드 수정하기
        val tokens = Tokens(
            accessToken = authOutput.accessToken,
            accessTokenExpiration = authOutput.accessTokenExpiration.toInstant(),
            refreshToken = authOutput.refreshToken,
            refreshTokenExpiration = authOutput.refreshTokenExpiration.toInstant(),
        )
        val role = Role.valueOf(authOutput.role)
        jwtStore.storeTokens(tokens)
        roleStore.storeRole(role)
    }
}
