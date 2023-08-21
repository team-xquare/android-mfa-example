plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
        Plugins.KOTLIN_SERIALIZATION,
    )
}

android {
    namespace = "com.xquare.domain.meal"
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
        Libraries.Koin.KOIN,
        Libraries.Datastore.DATASTORE_PREFERENCES,
        Libraries.Kotlin.DATETIME,
        Libraries.Kotlin.SERIALIZATION_JSON,
    )
    implementation(project(":core:core-database"))
    implementation(project(":core:core-datastore"))
    implementation(project(":core:core-network"))
}
