plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    // Annotation processing
    id(libs.plugins.ksp.get().pluginId)
    id(libs.plugins.kapt.get().pluginId)

    alias(libs.plugins.kotlin.serialization)

    id(libs.plugins.parcelize.get().pluginId)
//    id(libs.plugins.hilt.get().pluginId)
    id(libs.plugins.safeArgs.get().pluginId)
    id("com.google.gms.google-services")
}

android {
    namespace = "da.chelimo.tiktokclone"
    compileSdk = 34


    defaultConfig {
        val majorRelease = 1
        val defaultRelease = 0
        val minorRelease = 0

        applicationId = "da.chelimo.tiktokclone"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 34

        versionCode = (majorRelease * 100) + (defaultRelease * 10) + minorRelease
        versionName = "$majorRelease.$defaultRelease.$minorRelease"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion =("1.5.1")
    }

    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget =("1.8")
        freeCompilerArgs = listOf("-Xallow-result-return-type")
    }
}

dependencies {

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.splashScreen)
    implementation(libs.androidx.navigation)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)


    // Compose UI libraries
//    implementation(libs.compose.glide)
    implementation(libs.compose.coil)
    implementation(libs.compose.coil.networking)
    implementation(libs.compose.googleFonts)
    implementation(libs.compose.cloudy)

//     Network library
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshiconverter)
    implementation(libs.retrofit.okhttp.logger)

    // Firebase
    implementation(project.dependencies.platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.firestore)


    // Serialization
    implementation(libs.kotlin.serialization)
    implementation(libs.moshi)
    implementation(libs.moshi.reflect)

//    Local caching
    implementation(libs.androidx.datastore.preferences)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)


    // Others
    implementation(libs.logging.timber)
    implementation(libs.jodaTime)

    // Google Android
    implementation(libs.play.services.location)
    implementation(libs.androidx.work.runtime.ktx)

    // Timber
    implementation(libs.logging.timber)

    // Hilt
//    implementation(libs.hilt.android)
//    implementation(libs.androidx.hilt.work)
//    implementation(libs.androidx.hilt.navigation.compose)
//    kapt(libs.hilt.compiler)
//    kapt(libs.androidx.hilt.compiler)

    // Koin
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    // Splash Screen
    implementation(libs.androidx.splashScreen)


    // Test dependencies
    testImplementation(libs.junit)
    testImplementation(libs.hamcrest)
    testImplementation(libs.core.ktx)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.junit.ktx)
    testImplementation(libs.androidx.core.testing)

    // Android Test dependencies
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}

kapt {
    correctErrorTypes = true
}