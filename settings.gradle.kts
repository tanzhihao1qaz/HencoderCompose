pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
        /* maven{
             isAllowInsecureProtocol = true
             url = uri("./repo")
         }*/
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        /*maven{
            isAllowInsecureProtocol = true
            url = uri("./repo")
        }*/
    }
    // 创建versionCatalogs方式有两种，然后使用的话都是一样，所以只介绍创建
    // （单个项目使用推荐这个）
    // 方式一：就是在settings.gradle里，通过create函数定义每个依赖
    // （多个项目使用推荐这个，这样能多项目共用一份toml文件达到管理一致）
    // 方式二：创建toml文件，里面定义好每个依赖，这里toml文件的存放位置有点讲就，如果是放在根目录的gradle里，则无需其他操作，as会自动导入；
    //        如果是放在非根目录的gradle文件夹里，则要在create函数里通过from(files("xxx.toml"))方式导入，这样写implementation时才能识别并自动补全
    versionCatalogs {
        create("androidxLibs") {
            // alias（随便起）
            // group
            // artifact
            // version
            library("core-ktx", "androidx.core", "core-ktx").version("1.8.0")
            library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").version("2.6.1")
            library("activity-compose", "androidx.activity", "activity-compose").version("1.7.0")
            library("navigation-fragment-ktx", "androidx.navigation", "navigation-fragment-ktx").version("2.5.3")
            library("navigation-ui-ktx", "androidx.navigation", "navigation-ui-ktx").version("2.5.3")

            bundle("androidx", listOf("core-ktx", "lifecycle-runtime-ktx", "activity-compose", "navigation-ui-ktx", "navigation-fragment-ktx"))
        }
        create("composeLibs") {
            // 关于compose-bom是什么，为什么下面的其他依赖不需要版本号？自行百度Jetpack Compose BOM
            library("compose-bom", "androidx.compose", "compose-bom").version("2023.03.00")
            library("ui", "androidx.compose.ui", "ui").withoutVersion()
            library("ui-graphics", "androidx.compose.ui", "ui-graphics").withoutVersion()
            library("ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").withoutVersion()
            library("material3", "androidx.compose.material3", "material3").withoutVersion()

            bundle("compose", listOf("compose-bom", "ui", "ui-graphics", "ui-tooling-preview", "material3"))
        }
        create("navPluginLibs") {
            library("asm", "org.ow2.asm", "asm").version("9.2")
            library("asm-tree", "org.ow2.asm", "asm-tree").version("9.2")
            library("kotlinpoet", "com.squareup", "kotlinpoet").version("1.10.2")
            library("commons-io", "commons-io", "commons-io").version("2.6")
            library("gradle", "com.android.tools.build", "gradle").version("7.4.2")

            bundle("navPlugin", kotlin.collections.listOf("asm", "asm-tree", "kotlinpoet", "commons-io", "gradle"))
        }
        create("versionLibs") {
            version("compileSdk", "33")
            version("minSdk", "24")
            version("targetSdk", "33")
            version("composeCompiler", "1.4.3")
        }
        create("pluginLibs") {
            // 插件的名字定义不能有:，因为versionCataLogs是在上面的gradlePluginPortal仓库下载插件，这个仓库规定了插件的命名规则
            // 比如阿里的ARouter就不能用cataLogs进行版本管理
            plugin("application", "com.android.application").version("7.4.1")
            plugin("library", "com.android.library").version("7.4.2")
            plugin("kotlin", "org.jetbrains.kotlin.android").version("1.8.10")
            plugin("kotlinJvm", "org.jetbrains.kotlin.jvm").version("1.8.10")
            plugin("gradlePluginPublish", "com.gradle.plugin-publish").version("1.1.0")
            plugin("navPlugin", "io.github.tanzhihao1qaz.nav-plugin").version("1.2")
        }
    }
}

rootProject.name = "HencoderCompose"
include(":app")
include(":nav-plugin")
include(":nav-plugin-runtime")
include(":ft-home")
include(":ft-community")
include(":ft-mine")
include(":ft-scene")
include(":lib-common")
