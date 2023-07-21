plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.core_network"
    compileSdk = ProjectConfig.Sdk.COMPILE_SDK

    defaultConfig { minSdk = ProjectConfig.Sdk.MINIMUM_SDK }
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
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Retrofit.RETROFIT,
        Libraries.Retrofit.CONVERTER_GSON,
        Libraries.Koin.KOIN,
    )
}