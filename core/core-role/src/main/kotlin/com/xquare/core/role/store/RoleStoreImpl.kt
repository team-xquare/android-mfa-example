package com.xquare.core.role.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.xquare.core.role.Role
import com.xquare.core.role.exception.RoleNotFoundException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class RoleStoreImpl(
    private val dataStore: DataStore<Preferences>,
) : RoleStore {
    override fun loadRole(): Flow<Role> {
        return dataStore.data.map { preferences ->
            val value = preferences[KEY_ROLE] ?: throw RoleNotFoundException()
            Role.valueOf(value)
        }
    }

    override suspend fun storeRole(role: Role) {
        dataStore.edit { preferences ->
            preferences[KEY_ROLE] = role.name
        }
    }

    override suspend fun clearRole() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val KEY_ROLE = stringPreferencesKey("role")
    }
}
