plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.core.application"
    compileSdk = AndroidConfig.Sdk.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.Sdk.MINIMUM_SDK
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = true
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
    composeOptions {
        kotlinCompilerExtensionVersion =
            AndroidConfig.ComposeOptions.VERSION_KOTLIN_COMPILER_EXTENSION
    }
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Koin.KOIN,
        Libraries.Xds.XDS,
        Libraries.Lifecycle.VIEWMODEL,
        Libraries.Lifecycle.VIEWMODEL_COMPOSE,
    )
}