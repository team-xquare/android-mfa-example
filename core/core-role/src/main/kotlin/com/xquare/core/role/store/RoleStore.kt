package com.xquare.core.role.store

import com.xquare.core.role.Role
import kotlinx.coroutines.flow.Flow

interface RoleStore {
    fun loadRole(): Flow<Role>
    suspend fun storeRole(role: Role)
    suspend fun clearRole()
}
