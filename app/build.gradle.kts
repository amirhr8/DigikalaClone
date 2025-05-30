import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)

}
// خواندن فایل key.properties
val apikeyPropertiesFile = rootProject.file("key.properties")
val apikeyProperties = Properties().apply {
    load(FileInputStream(apikeyPropertiesFile))
}

// گرفتن مقدار کلید از فایل
val apiKey = apikeyProperties["X_API_KEY"] as String

android {
    namespace = "com.example.digikalaapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.digikalaapp"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        // مقدار دهی BuildConfigField
        buildConfigField("String", "X_API_KEY", "\"$apiKey\"")

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
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp.logging)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // datastore
    implementation(libs.datastore)


    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // compose navigation
    implementation(libs.navigation.compose)

    // animations
    implementation(libs.lottie.compose)

    // coil
    implementation(libs.coil.compose)

    // swipe refresh
    implementation(libs.accompanist.swiperefresh)

    // system ui controller
    implementation(libs.accompanist.systemuicontroller)

    // accompanist pager
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    // paging
    implementation(libs.paging.compose)

    // chart
    implementation(libs.vico.compose)

    // gson
    implementation(libs.gson)

    // material icons
    implementation(libs.material.icons.extended)

}