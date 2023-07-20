object Libraries {
    object Android {
        private const val VERSION_CORE = "1.9.0"
        private const val VERSION_APPCOMPAT = "1.6.1"

        const val CORE = "androidx.core:core-ktx:$VERSION_CORE"
        const val APPCOMPAT = "androidx.appcompat:appcompat:$VERSION_APPCOMPAT"
    }

    object Material {
        private const val VERSION_MATERIAL = "1.9.0"

        const val MATERIAL = "com.google.android.material:material:$VERSION_MATERIAL"
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
    }

    object Retrofit {
        private const val VERSION_RETROFIT = "2.9.0"

        const val RETROFIT = "com.squareup.retrofit2:retrofit:$VERSION_RETROFIT"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:$VERSION_RETROFIT"
    }
}
