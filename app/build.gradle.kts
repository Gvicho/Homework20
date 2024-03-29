plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin") // for navigation

    //Hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

    // for ksp
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.homework20"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.homework20"
        minSdk = 24
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

        debug {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

//Hilt
// Allow references to generated code
kapt {
    correctErrorTypes = true
}





dependencies {
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")// for room

    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")// for okHttp logger interceptor


    //Datastore
    implementation("androidx.datastore:datastore-preferences-core:1.0.0")// for DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    implementation("com.google.firebase:firebase-common-ktx:20.4.2")// for Hilt
    kapt("com.google.dagger:hilt-android-compiler:2.47")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit

    implementation ("com.squareup.moshi:moshi:1.9.3") // Moshi
    implementation ("com.squareup.moshi:moshi-kotlin:1.9.3") // For Kotlin support

    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")// Retrofit Converter for Moshi



    implementation("com.github.bumptech.glide:glide:4.16.0") // for glide


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1") // coroutines


    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0") // For ViewModel
    implementation ("androidx.activity:activity-ktx:1.8.2") // For ViewModel

    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6") // for navigation
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")// for navigation

    implementation("androidx.fragment:fragment-ktx:1.6.2")//for fragment

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}