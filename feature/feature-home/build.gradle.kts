plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.feature.home"
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
        Libraries.ConstraintLayout.CONSTRAINT_LAYOUT,
        Libraries.Xds.XDS,
    )
}
