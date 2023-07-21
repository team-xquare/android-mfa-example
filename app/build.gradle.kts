plugins {
    id(
        Plugins.APPLICATION,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.androidv2"
    compileSdk = ProjectConfig.Sdk.COMPILE_SDK

    defaultConfig {
        applicationId = "com.xquare.androidv2"
        minSdk = ProjectConfig.Sdk.MINIMUM_SDK
        targetSdk = ProjectConfig.Sdk.TARGET_SDK
        versionCode = ProjectConfig.AppVersion.VERSION_CODE
        versionName = ProjectConfig.AppVersion.VERSION_NAME
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
        sourceCompatibility = ProjectConfig.CompileOptions.SOURCE_COMPATIBILITY
        targetCompatibility = ProjectConfig.CompileOptions.TARGET_COMPATIBILITY
    }
    kotlinOptions { jvmTarget = ProjectConfig.KotlinOptions.JVM_TARGET }
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
