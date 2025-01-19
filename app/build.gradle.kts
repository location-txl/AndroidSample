/**
 * The plugins block is used to apply Gradle plugins to the project.
 * Plugins can add new tasks, extend the build script, and provide additional functionality.
 */
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.serialization)
}

/**
 * The android block is used to configure the Android-specific settings for the project.
 * This includes settings like the namespace, compile SDK version, default configuration, build types, and more.
 */
android {
    namespace = "com.location.androidsample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.location.androidsample"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

/**
 * The dependencies block is used to declare the dependencies for the project.
 * Dependencies can be libraries, modules, or other projects that the current project depends on.
 */
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    /* hilt start */
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    /* hilt end */

    /* kotlin serialization start */
    implementation(libs.kotlinx.serialization.json)
    /* kotlin serialization end */

    /* retrofit start */
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit.kotlin.serialization)
    /* retrofit end */
}
