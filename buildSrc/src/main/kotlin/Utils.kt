import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.initialization.dsl.ScriptHandler.CLASSPATH_CONFIGURATION
import org.gradle.plugin.use.PluginDependenciesSpec

fun DependencyHandler.implementation(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("implementation", dependency) }
}

fun DependencyHandler.androidTestImplementation(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("androidTestImplementation", dependency) }
}

fun DependencyHandler.testImplementation(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("testImplementation", dependency) }
}

fun DependencyHandler.kapt(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("kapt", dependency) }
}

fun DependencyHandler.classpath(vararg dependencies: String) {
    dependencies.forEach { dependency -> add(CLASSPATH_CONFIGURATION, dependency) }
}

fun PluginDependenciesSpec.id(vararg ids: String) {
    ids.forEach { id -> this.id(id) }
}
