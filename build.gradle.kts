buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(
            dependencies = arrayOf(
                ProjectConfig.GradlePlugin.GRADLE_ANDROID,
                ProjectConfig.GradlePlugin.GRADLE_KOTLIN,
            ),
        )
    }
}
