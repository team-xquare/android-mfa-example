package com.xquare.androidv2.di

import com.xquare.androidv2.BuildConfig
import com.xquare.androidv2.RootActivityViewModel
import com.xquare.common.di.DiQualifier
import com.xquare.core.database.di.databaseModule
import com.xquare.core.datastore.di.dataStoreModule
import com.xquare.core.jwt.di.jwtModule
import com.xquare.core.network.di.networkModule
import com.xquare.core.role.di.roleModule
import com.xquare.domain.meal.di.mealDomainModule
import com.xquare.domain.user.di.userDomainModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val xquareModule = module {
    includes(
        coreModule,
        domainModule,
        httpModule,
    )
    single(qualifier = named(DiQualifier.Build.DEBUG)) { BuildConfig.DEBUG }
    viewModel { RootActivityViewModel(get()) }
    viewModelOf(::RootActivityViewModel)
}

private val coreModule: Module
    inline get() = module {
        includes(
            databaseModule,
            dataStoreModule,
            jwtModule,
            networkModule,
            roleModule,
        )
    }

private val domainModule: Module
    inline get() = module {
        includes(
            mealDomainModule,
            userDomainModule,
        )
    }
