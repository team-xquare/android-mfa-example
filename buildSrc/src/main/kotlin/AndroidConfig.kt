import org.gradle.api.JavaVersion

object AndroidConfig {

    object Sdk {
        const val COMPILE_SDK = 33
        const val MINIMUM_SDK = 23
        const val TARGET_SDK = 33
    }

    object AppVersion {
        const val VERSION_CODE = 2_0_0_0_1
        const val VERSION_NAME = "v2.0.0-alpha1"
    }

    object CompileOptions {
        val SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
        val TARGET_COMPATIBILITY = JavaVersion.VERSION_17
    }

    object KotlinOptions {
        val JVM_TARGET = JavaVersion.VERSION_17.toString()
    }

    object ComposeOptions {
        const val VERSION_KOTLIN_COMPILER_EXTENSION = "1.4.3"
    }
}
