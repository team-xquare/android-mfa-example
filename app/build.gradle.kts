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

        buildConfigField("String", "BASE_URL_PROD", AndroidConfig.Http.BASE_URL_PROD)
        buildConfigField("String", "BASE_URL_STAG", AndroidConfig.Http.BASE_URL_STAG)
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
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
        Libraries.Koin.KOIN,
        Libraries.Lifecycle.VIEWMODEL,
        Libraries.Kotlin.DATETIME,
        Libraries.ConstraintLayout.CONSTRAINT_LAYOUT,
        Libraries.Navigation.NAVIGATION,
        Libraries.Navigation.NAVIGATION_UI,
        Libraries.Xds.XDS,
        Libraries.Compose.COMPOSE,
        Libraries.Compose.COMPOSE_TOOLING,
        Libraries.Compose.COMPOSE_ANIMATION,
        Libraries.Flipper.FLIPPER,
        Libraries.Flipper.FLIPPER_PLUGIN_NETWORK,
        Libraries.SoLoader.SOLOADER,
    )

    // todo implement function receives vararg params
    implementation(project(":common:common-date"))
    implementation(project(":common:common-di"))
    implementation(project(":common:common-project"))
    implementation(project(":core:core-database"))
    implementation(project(":core:core-datastore"))
    implementation(project(":core:core-jwt"))
    implementation(project(":core:core-network"))
    implementation(project(":core:core-ui"))
    implementation(project(":domain:domain-meal"))
    implementation(project(":domain:domain-user"))
    implementation(project(":feature:feature-allservices"))
    implementation(project(":feature:feature-application"))
    implementation(project(":feature:feature-feed"))
    implementation(project(":feature:feature-home"))
    implementation(project(":feature:feature-mypage"))
    implementation(project(":feature:feature-schedule"))
    implementation(project(":feature:feature-auth"))
}
