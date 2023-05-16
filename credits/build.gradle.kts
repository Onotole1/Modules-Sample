plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.credits"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures.viewBinding = true
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.github.terrakok:cicerone:7.1")
    val moxyVersion = "2.2.2"
    implementation("com.github.moxy-community:moxy-ktx:$moxyVersion")
    implementation("com.github.moxy-community:moxy-androidx:$moxyVersion")
    kapt("com.github.moxy-community:moxy-compiler:$moxyVersion")
    implementation("io.insert-koin:koin-android:3.4.0")
    api(project(":credits-core"))
    implementation(project(":app"))
}