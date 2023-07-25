package com.xquare.androidv2

import android.app.Application
import com.xquare.androidv2.di.xquareModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class XquareApplication : Application() {

    // todo 적절한 모듈로 이동
    private val isDebugEnabled: Boolean
        get() = BuildConfig.DEBUG

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            if (isDebugEnabled) {
                androidLogger()
            }

            androidContext(this@XquareApplication)
            modules(xquareModule)
        }
    }
}
