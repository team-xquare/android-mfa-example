@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "XQUARE Android v2"

include(
    ":app",
    ":core:core-data",
    ":core:core-database",
    ":core:core-network",
    ":feature:feature-allservices",
    ":feature:feature-application",
    ":feature:feature-feed",
    ":feature:feature-home",
    ":feature:feature-mypage",
    ":feature:feature-schedule",
    ":feature:feature-signin",
)
