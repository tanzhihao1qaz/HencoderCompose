@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java-library")
//    alias(pluginLibs.plugins.kotlin)
    alias(pluginLibs.plugins.kotlinJvm)
    alias(pluginLibs.plugins.gradlePluginPublish) // 这个是发布到远程gradle plugin仓库用的
    id("maven-publish") // 这个是发布本地用的
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(gradleApi())
    implementation(navPluginLibs.bundles.navPlugin)
    implementation(kotlin("stdlib"))
//    implementation(project(mapOf("path" to ":nav-plugin-runtime")))
    implementation ("com.sleepingcat.jetpack:nav-plugin-runtime:1.0")
}

group = "io.github.tanzhihao1qaz" // 发布到中央仓库的命名规则：前两个域名要可访问（io.github），后面的要是github的用户名
version = "1.0" //插件版本

/*gradlePlugin {
    website = "https://github.com/tanzhihao1qaz"
    vcsUrl = "https://github.com/tanzhihao1qaz/nav-plugin/blob/main/README.md"
    plugins {
        //navPlugin名称任意
        create("navPlugin") {
            id = "io.github.tanzhihao1qaz.nav-pluginio.github.tanzhihao1qaz.nav-plugin"
            displayName = "nav-plugin"
            implementationClass = "com.sleepingcat.nav_plugin.NavPlugin"
            description = "navigation路由表生成插件"
            tags.set(["navigation", "transform", "gradle7.4.2"])
        }
    }
}*/

publishing {
    publications {
        create<MavenPublication>("NavPlugin")  {
            from(components["java"])
            groupId = "io.github.tanzhihao1qaz"
            artifactId = "nav-plugin"
            version = "1.0"
        }
    }
    repositories {
        maven {
            url = uri("../repo")
        }
    }
}
