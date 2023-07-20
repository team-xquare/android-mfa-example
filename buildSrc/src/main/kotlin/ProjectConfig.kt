import org.gradle.api.JavaVersion

object ProjectConfig {

    object Sdk {
        const val COMPILE_SDK = 33
        const val MINIMUM_SDK = 23
        const val TARGET_SDK = 33
    }

    object AppVersion {
        const val VERSION_CODE = 2_0_0
        const val VERSION_NAME = "2.0.0"
    }

    object CompileOptions {
        val SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
        val TARGET_COMPATIBILITY = JavaVersion.VERSION_17
    }

    object KotlinOptions {
        val JVM_TARGET = JavaVersion.VERSION_17.toString()
    }
}
