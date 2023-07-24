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
    ":feature:main:feature-main",
    ":feature:main:feature-main-all",
    ":feature:main:feature-main-application",
    ":feature:main:feature-main-feed",
    ":feature:main:feature-main-home",
    ":feature:main:feature-main-schedule",
)
