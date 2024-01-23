// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false // for Hilt
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false // for KSP
}

// safeargs
buildscript {
    repositories {
        google()
        mavenCentral() // for glide
    }

    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
        classpath ("com.google.devtools.ksp:symbol-processing-gradle-plugin:1.8.10-1.0.9")
        classpath ("com.android.tools.build:gradle:7.0.4") // Use the Android Gradle plugin version compatible with your project
    }
}