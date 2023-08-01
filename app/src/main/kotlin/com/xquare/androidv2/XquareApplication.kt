package com.xquare.androidv2

import android.app.Application
import com.google.android.material.color.DynamicColors
import com.xquare.androidv2.di.xquareModule
import com.xquare.core.common.util.isDebugEnabled
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class XquareApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initDynamicColors()
    }

    private fun initKoin() {
        startKoin {
            modules(xquareModule)
            androidContext(this@XquareApplication)
            if (isDebugEnabled) {
                androidLogger()
            }
        }
    }

    private fun initDynamicColors() {
        DynamicColors.applyToActivitiesIfAvailable(this@XquareApplication)
    }
}
