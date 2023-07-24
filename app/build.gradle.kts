plugins {
    id(
        Plugins.APPLICATION,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.androidv2"
    compileSdk = AndroidConfig.Sdk.COMPILE_SDK

    defaultConfig {
        applicationId = "com.xquare.androidv2"
        minSdk = AndroidConfig.Sdk.MINIMUM_SDK
        targetSdk = AndroidConfig.Sdk.TARGET_SDK
        versionCode = AndroidConfig.AppVersion.VERSION_CODE
        versionName = AndroidConfig.AppVersion.VERSION_NAME
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.CompileOptions.SOURCE_COMPATIBILITY
        targetCompatibility = AndroidConfig.CompileOptions.TARGET_COMPATIBILITY
    }
    kotlinOptions { jvmTarget = AndroidConfig.KotlinOptions.JVM_TARGET }
    buildFeatures { dataBinding = true }
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Material.MATERIAL,
        Libraries.ConstraintLayout.CONSTRAINT_LAYOUT,
        Libraries.Navigation.NAVIGATION,
        Libraries.Navigation.NAVIGATION_UI,
        Libraries.Xds.XDS,
    )
}
