// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.geelib.360.cn/nexus/repository/replugin/")
        }
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath("com.qihoo360.replugin:replugin-host-gradle:3.1.0")
//        classpath("com.github.tanzhihao1qaz.lib_plugin_demo:catalog:1.0")
    }
}

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
