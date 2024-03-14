@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(pluginLibs.plugins.application)
    alias(pluginLibs.plugins.kotlin)
    id("NavPlugin") // 发现如果插件是用kts写，就只能用properties定义的名字引用，用gradle写，则用groupId + artifactId + version来引用，也就是那个io.github.tanzhihao1qaz.nav-plugin
    id("kotlin-kapt")
}

android {
    namespace = "com.sleepingcat.hencodercompose"
    compileSdk = versionLibs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.sleepingcat.hencodercompose"
        minSdk = versionLibs.versions.minSdk.get().toInt()
        targetSdk = versionLibs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionLibs.versions.composeCompiler.get()
    }

    /*packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }*/
}

dependencies {
    implementation(networkLibs.bundles.network)
    implementation(imageLibs.bundles.image)
    implementation(platform(composeLibs.compose.bom))
    implementation(composeLibs.bundles.compose)
    implementation("com.sleepingcat.jetpack:nav-plugin-runtime:1.0")
    implementation(project(mapOf("path" to ":lib-common")))
//    implementation(project(mapOf("path" to ":ft-tag")))
//    implementation(project(mapOf("path" to ":ft-category")))
//    implementation(project(mapOf("path" to ":ft-home")))
//    implementation(project(mapOf("path" to ":ft-user")))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    kapt(imageLibs.glide.compiler)
}