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
    ":common:common-date",
    ":common:common-di",
    ":common:common-project",
    ":core:core-common",
    ":core:core-database",
    ":core:core-datastore",
    ":core:core-jwt",
    ":core:core-network",
    ":core:core-ui",
    ":domain:domain-meal",
    ":domain:domain-user",
    ":feature:feature-allservices",
    ":feature:feature-application",
    ":feature:feature-auth",
    ":feature:feature-feed",
    ":feature:feature-home",
    ":feature:feature-mypage",
    ":feature:feature-schedule",
)
