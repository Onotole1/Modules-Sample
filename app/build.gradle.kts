plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.modules"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
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
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    val moxyVersion = "2.2.2"
    implementation("com.github.moxy-community:moxy-ktx:$moxyVersion")
    implementation("com.github.moxy-community:moxy-androidx:$moxyVersion")
    kapt("com.github.moxy-community:moxy-compiler:$moxyVersion")
    implementation("com.github.terrakok:cicerone:7.1")
    implementation("io.insert-koin:koin-android:3.4.0")

    implementation(project("${parent!!.path}:products-core"))
}