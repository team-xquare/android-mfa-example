package com.xquare.domain.user.repository

import com.xquare.domain.user.datasource.database.UserDatabaseDataSource
import com.xquare.domain.user.datasource.datastore.UserDataStoreDataSource
import com.xquare.domain.user.datasource.network.UserNetworkDataSource
import com.xquare.domain.user.model.input.LoginInput
import com.xquare.domain.user.model.input.RegisterInput
import com.xquare.domain.user.model.output.AuthOutput

internal class UserRepositoryImpl(
    private val userDatabaseDataSource: UserDatabaseDataSource,
    private val userDataStoreDataSource: UserDataStoreDataSource,
    private val userNetworkDataSource: UserNetworkDataSource,
) : UserRepository {
    override suspend fun register(input: RegisterInput) {
        userNetworkDataSource.register(input)
    }

    override suspend fun login(input: LoginInput): AuthOutput {
        return userNetworkDataSource.login(input)
    }

    // fixme probably not used
    override suspend fun reissueToken(): AuthOutput {
        return userNetworkDataSource.reissueToken()
    }
}
