@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(pluginLibs.plugins.library)
    alias(pluginLibs.plugins.kotlin)
}

android {
    namespace = "com.sleepingcat.ft_mine"
    compileSdk = versionLibs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = versionLibs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(androidxLibs.bundles.androidx)
    implementation ("com.sleepingcat.jetpack:nav-plugin-runtime:1.0")
    implementation(platform(composeLibs.compose.bom))
    implementation(composeLibs.bundles.compose)
    implementation(project(mapOf("path" to ":lib-common")))
}