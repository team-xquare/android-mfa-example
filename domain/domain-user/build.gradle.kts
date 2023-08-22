plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
        Plugins.KOTLIN_SERIALIZATION,
    )
}

android {
    namespace = "com.xquare.domain.user"
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
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            AndroidConfig.ComposeOptions.VERSION_KOTLIN_COMPILER_EXTENSION
    }
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Ktor.KTOR,
        Libraries.Datastore.DATASTORE_PREFERENCES,
        Libraries.Koin.KOIN,
        Libraries.Kotlin.DATETIME,
        Libraries.Kotlin.SERIALIZATION_JSON,
    )
    implementation(project(":core:core-database"))
    implementation(project(":core:core-datastore"))
    implementation(project(":core:core-jwt"))
    implementation(project(":core:core-network"))
    implementation(project(":common:common-di"))
}
