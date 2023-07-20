fun org.gradle.api.artifacts.dsl.DependencyHandler.implementation(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("implementation", dependency) }
}

fun org.gradle.api.artifacts.dsl.DependencyHandler.androidTestImplementation(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("androidTestImplementation", dependency) }
}

fun org.gradle.api.artifacts.dsl.DependencyHandler.testImplementation(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("testImplementation", dependency) }
}

fun org.gradle.api.artifacts.dsl.DependencyHandler.kapt(vararg dependencies: String) {
    dependencies.forEach { dependency -> add("kapt", dependency) }
}

fun org.gradle.plugin.use.PluginDependenciesSpec.id(vararg ids: String) {
    ids.forEach { id -> this.id(id) }
}
