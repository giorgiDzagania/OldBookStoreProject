plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
}

android {
    namespace = "com.madeit.oldbookstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.madeit.oldbookstore"
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
        viewBinding = true
        dataBinding = true
    }

}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.navigation:navigation-fragment:2.5.0")
    implementation("androidx.navigation:navigation-ui:2.5.0")

    // Old support library (commented out)
    // implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.android.gms:play-services-auth:21.2.0")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("com.google.firebase:firebase-storage:21.0.0")
    implementation("com.google.android.gms:play-services-auth:21.2.0")
    implementation("com.github.bumptech.glide:glide:4.13.2")
    implementation("com.google.mlkit:common:18.10.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.2")
    implementation("androidx.browser:browser:1.4.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Old material library version (commented out)
    // implementation("com.google.android.material:material:1.2.1")

    // Old lifecycle extensions (commented out)
    // implementation("android.arch.lifecycle:extensions:1.1.1")

    // Google services plugin

    // Firebase UI for Firebase Realtime Database (commented out)
    // implementation("com.firebaseui:firebase-ui-database:6.2.1")

    // TFLite and Firebase ML dependencies
    implementation(platform("com.google.firebase:firebase-bom:29.3.0"))
    implementation("com.google.firebase:firebase-ml-modeldownloader:25.0.0")
    implementation("org.tensorflow:tensorflow-lite-task-text:0.3.0")
}