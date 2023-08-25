package com.xquare.core.role.di

import com.xquare.core.role.store.RoleStore
import com.xquare.core.role.store.RoleStoreImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val roleModule: Module
    get() = module {
        single<RoleStore> { RoleStoreImpl(get()) }
    }
