plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.anehta.mvvmtp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anehta.mvvmtp"
        minSdk = 28
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Kotlin Coroutines
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")

    //ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //Kodein Dependancy Injection
    //implementation("org.kodein.di:kodein-di-generic-jvm:7.0.0")
    //implementation("org.kodein.di:kodein-di-framework-android-x:7.0.0")

    //Android Room
    //implementation("android.arch.persistence.room:runtime:1.1.1")
    //implementation("androidx.room:room-ktx:2.6.1")
    //implementation("androidx.room:room-compiler:2.6.1")

    //머터리얼 디자인
    implementation("com.google.android.material:material:1.11.0")

    //안드로이드 네비게이션 아키텍쳐
    //implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    //implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


}