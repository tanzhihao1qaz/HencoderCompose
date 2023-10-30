@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java-library")
    alias(pluginLibs.plugins.kotlinJvm)
    id("maven-publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


publishing {
    publications {
        create<MavenPublication>("NavPluginRuntime"){
            from(components["java"])
            groupId = "com.sleepingcat.jetpack"
            artifactId = "nav-plugin-runtime"
            version = "1.0"
        }
    }
    repositories {
        maven {
            url = uri("../repo")
        }
    }
}

