package com.xquare.androidv2

import android.app.Application
import com.xquare.androidv2.di.xquareModule
import com.xquare.core.common.util.isDebugEnabled
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class XquareApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
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
}
