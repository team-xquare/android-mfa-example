plugins {
    id(
        Plugins.LIBRARY_ANDROID,
        Plugins.KOTLIN_ANDROID,
        Plugins.KAPT,
    )
}

android {
    namespace = "com.xquare.feature_main_home"
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
}

dependencies {
    implementation(
        Libraries.Android.CORE,
        Libraries.Android.APPCOMPAT,
        Libraries.Xds.XDS,
    )
}
