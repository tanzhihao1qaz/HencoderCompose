// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(pluginLibs.plugins.kotlinJvm) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(pluginLibs.plugins.application) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(pluginLibs.plugins.library) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(pluginLibs.plugins.kotlin) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(pluginLibs.plugins.navPlugin) apply false
}