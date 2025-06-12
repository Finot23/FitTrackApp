// Este es el archivo build.gradle.kts (Module: app)
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // 1. Aplica el plugin de Google Services aquí
    id("com.google.gms.google-services") version "4.4.2" apply false
    //id("com.android.application")
}

android {
    namespace = "com.example.fittrack"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fittrack"
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
}

dependencies {
    // Dependencias existentes
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // 2. Añade la plataforma de Firebase BOM (para gestionar versiones)
    // Revisa la última versión de Firebase BOM en la consola de Firebase o en la documentación oficial.
    // Al momento de la última revisión, 33.0.0 o superior es común.
    implementation(platform("com.google.firebase:firebase-bom:33.15.0")) // <-- VERIFICA ESTA VERSIÓN EN TU CONSOLA DE FIREBASE

    // 3. Añade las dependencias específicas de Firebase que necesitas
    // Autenticación de Firebase
    implementation("com.google.firebase:firebase-auth-ktx")
    // Firestore (base de datos, la necesitarás para guardar datos de usuario)
    implementation("com.google.firebase:firebase-firestore-ktx")

    // Dependencias para arquitectura MVVM (ViewModels y LiveData)
    // Lifecycle components: ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    // lifecycle-runtime-ktx es a menudo útil también
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")


    // Si quieres usar actividades y fragmentos con extensiones KTX (recomendado)
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.7.0")

}