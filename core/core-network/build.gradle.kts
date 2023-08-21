plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
        Plugins.KOTLIN_SERIALIZATION,
    )
}

android {
    namespace = "com.xquare.core.network"
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
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Ktor.KTOR,
        Libraries.Ktor.CIO,
        Libraries.Ktor.CONTENT_NEGOTIATION,
        Libraries.Ktor.AUTH,
        Libraries.Ktor.KOTLIN_SERIALIZATION_JSON,
        Libraries.Ktor.LOGGING,
        Libraries.Koin.KOIN,
        Libraries.Kotlin.DATETIME,
        Libraries.Kotlin.SERIALIZATION_JSON,
    )
    implementation(project(":common:common-date"))
    implementation(project(":common:common-di"))
    implementation(project(":common:common-project"))
}
