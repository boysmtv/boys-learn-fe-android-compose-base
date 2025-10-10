plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.movie.compose.core.network"
    compileSdk = property("COMPILE_SDK").toString().toInt()

    defaultConfig {
        minSdk = property("MIN_SDK").toString().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "TMDB_BASE_URL", "\"${property("TMDB_BASE_URL")}\"")
        buildConfigField("String", "TMDB_API_KEY", "\"${property("TMDB_API_KEY")}\"")
        buildConfigField("String", "TMDB_BASE_URL_IMAGE_200", "\"${property("TMDB_BASE_URL_IMAGE_200")}\"")
        buildConfigField("String", "TMDB_BASE_URL_IMAGE_500", "\"${property("TMDB_BASE_URL_IMAGE_500")}\"")
        buildConfigField("String", "TMDB_BASE_URL_IMAGE_ORIGINAL", "\"${property("TMDB_BASE_URL_IMAGE_ORIGINAL")}\"")
    }

    buildTypes {
        debug {
            buildConfigField("String", "TMDB_BASE_URL", "\"${property("TMDB_BASE_URL")}\"")
            buildConfigField("String", "TMDB_API_KEY", "\"${property("TMDB_API_KEY")}\"")
            buildConfigField("String", "TMDB_BASE_URL_IMAGE_200", "\"${property("TMDB_BASE_URL_IMAGE_200")}\"")
            buildConfigField("String", "TMDB_BASE_URL_IMAGE_500", "\"${property("TMDB_BASE_URL_IMAGE_500")}\"")
            buildConfigField("String", "TMDB_BASE_URL_IMAGE_ORIGINAL", "\"${property("TMDB_BASE_URL_IMAGE_ORIGINAL")}\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "TMDB_BASE_URL", "\"${property("TMDB_BASE_URL")}\"")
            buildConfigField("String", "TMDB_API_KEY", "\"${property("TMDB_API_KEY")}\"")
            buildConfigField("String", "TMDB_BASE_URL_IMAGE_200", "\"${property("TMDB_BASE_URL_IMAGE_200")}\"")
            buildConfigField("String", "TMDB_BASE_URL_IMAGE_500", "\"${property("TMDB_BASE_URL_IMAGE_500")}\"")
            buildConfigField("String", "TMDB_BASE_URL_IMAGE_ORIGINAL", "\"${property("TMDB_BASE_URL_IMAGE_ORIGINAL")}\"")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.retrofit.adapter.rxjava3)
    implementation(libs.okhttp.logging)
    implementation(libs.moshi.core)
    implementation(libs.moshi.kotlin)
    implementation(libs.rxjava)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.rx3)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}