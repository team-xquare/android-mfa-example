package com.xquare.androidv2.di

import com.xquare.androidv2.BuildConfig
import com.xquare.common.di.DiQualifier
import com.xquare.common.project.isDebugEnabled
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val httpModule: Module
    get() = module {
        single(qualifier = named(DiQualifier.Http.BASE_URL)) {
            if (isDebugEnabled) {
                BuildConfig.BASE_URL_STAG
            } else {
                BuildConfig.BASE_URL_PROD
            }
        }
    }
