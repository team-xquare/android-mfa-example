object Libraries {
    object Android {
        private const val VERSION_CORE = "1.9.0"
        private const val VERSION_APPCOMPAT = "1.6.1"
        private const val VERSION_ACTIVITY = "1.7.2"

        const val CORE = "androidx.core:core-ktx:$VERSION_CORE"
        const val APPCOMPAT = "androidx.appcompat:appcompat:$VERSION_APPCOMPAT"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:$VERSION_ACTIVITY"
    }

    object Material {
        private const val VERSION_MATERIAL = "1.9.0"
        private const val VERSION_MATERIAL_COMPOSE = "1.1.1"

        const val MATERIAL = "com.google.android.material:material:$VERSION_MATERIAL"
        const val MATERIAL_COMPOSE =
            "androidx.compose.material3:material3:$VERSION_MATERIAL_COMPOSE"
    }

    object ConstraintLayout {
        private const val VERSION_CONSTRAINT_LAYOUT = "2.1.4"

        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:$VERSION_CONSTRAINT_LAYOUT"
    }

    object Navigation {
        private const val VERSION_NAVIGATION = "2.6.0"

        const val NAVIGATION = "androidx.navigation:navigation-fragment-ktx:$VERSION_NAVIGATION"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$VERSION_NAVIGATION"
        const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:$VERSION_NAVIGATION"
    }

    object Ktor {
        private const val VERSION_KTOR = "2.3.2"

        const val KTOR = "io.ktor:ktor-client-android:$VERSION_KTOR"
        const val CIO = "io.ktor:ktor-client-cio:$VERSION_KTOR"
        const val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:$VERSION_KTOR"
        const val AUTH = "io.ktor:ktor-client-auth:$VERSION_KTOR"
        const val KOTLIN_SERIALIZATION_JSON =
            "io.ktor:ktor-serialization-kotlinx-json:$VERSION_KTOR"
    }

    object Koin {
        private const val VERSION_KOIN = "3.4.2"
        private const val VERSION_KOIN_COMPOSE_ANDROID = "3.4.5"

        const val KOIN = "io.insert-koin:koin-android:$VERSION_KOIN"
        const val KOIN_COMPOSE =
            "io.insert-koin:koin-androidx-compose:$VERSION_KOIN_COMPOSE_ANDROID"
        const val KOIN_NAVIGATION = "io.insert-koin:koin-androidx-navigation:$VERSION_KOIN"
        const val KOIN_COMPOSE_NAVIGATION =
            "io.insert-koin:koin-androidx-compose-navigation:$VERSION_KOIN_COMPOSE_ANDROID"
    }

    object Room {
        private const val VERSION_ROOM = "2.5.2"

        const val ROOM = "androidx.room:room-ktx:$VERSION_ROOM"
        const val ROOM_COMPILER = "androidx.room:room-ktx:$VERSION_ROOM"
    }

    object Xds {
        private const val VERSION_XDS = "v0.2.0"

        const val XDS = "com.github.team-xquare:xquare-design-system-android:$VERSION_XDS"
    }

    object Compose {
        private const val VERSION_COMPOSE = "1.4.3"

        const val COMPOSE = "androidx.compose.ui:ui:$VERSION_COMPOSE"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:$VERSION_COMPOSE"
        const val COMPOSE_ANIMATION = "androidx.compose.animation:animation:$VERSION_COMPOSE"
    }

    object Lifecycle {
        private const val VERSION_LIFECYCLE = "2.6.1"

        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION_LIFECYCLE"
        const val VIEWMODEL_COMPOSE =
            "androidx.lifecycle:lifecycle-viewmodel-compose:$VERSION_LIFECYCLE"
    }

    object Kotlin {
        private const val VERSION_DATETIME = "0.4.0"
        private const val VERSION_SERIALIZATION_JSON = "1.5.1"

        const val DATETIME = "org.jetbrains.kotlinx:kotlinx-datetime:$VERSION_DATETIME"
        const val SERIALIZATION_JSON =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:$VERSION_SERIALIZATION_JSON"
    }

    object Datastore {
        private const val VERSION_DATASTORE = "1.0.0"

        const val DATASTORE_PREFERENCES =
            "androidx.datastore:datastore-preferences:$VERSION_DATASTORE"
    }
}
