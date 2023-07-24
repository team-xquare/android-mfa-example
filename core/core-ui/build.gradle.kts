plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.core.ui"
    compileSdk = ProjectConfig.Sdk.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfig.Sdk.MINIMUM_SDK
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
        sourceCompatibility = ProjectConfig.CompileOptions.SOURCE_COMPATIBILITY
        targetCompatibility = ProjectConfig.CompileOptions.TARGET_COMPATIBILITY
    }
    kotlinOptions { jvmTarget = ProjectConfig.KotlinOptions.JVM_TARGET }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Koin.KOIN,
        Libraries.Koin.KOIN_COMPOSE,
        Libraries.Xds.XDS,
        Libraries.Compose.COMPOSE,
        Libraries.Compose.COMPOSE_ANIMATION,
        Libraries.Compose.COMPOSE_TOOLING,
        Libraries.Lifecycle.VIEWMODEL,
        Libraries.Lifecycle.VIEWMODEL_COMPOSE,
    )
}
