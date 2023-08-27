package com.xquare.androidv2

import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.google.android.material.color.DynamicColors
import com.xquare.androidv2.di.xquareModule
import com.xquare.common.project.isDebugEnabled
import com.xquare.core.application.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class XquareApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initDynamicColors()
        initSoLoader()
        initFlipper()
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

    private fun initSoLoader() {
        SoLoader.init(this@XquareApplication, false)
    }

    private fun initFlipper() {
        if (isDebugEnabled && FlipperUtils.shouldEnableFlipper(this@XquareApplication)) {
            AndroidFlipperClient.getInstance(this@XquareApplication).apply {
                // todo make function receives collection of plugins by parameter
                addPlugin(DatabasesFlipperPlugin(this@XquareApplication))
                addPlugin(
                    InspectorFlipperPlugin(
                        this@XquareApplication,
                        DescriptorMapping.withDefaults(),
                    ),
                )
                addPlugin(NavigationFlipperPlugin.getInstance())
                addPlugin(NetworkFlipperPlugin())
                addPlugin(
                    SharedPreferencesFlipperPlugin(
                        this@XquareApplication,
                        // todo make const variable
                        "preferences-datastore-xquare",
                    ),
                )
            }.start()
        }
    }
}
