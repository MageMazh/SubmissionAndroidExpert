plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}
apply { from("../shared_dependencies.gradle") }

android {
    namespace = "com.d121211069.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "API_KEY", "\"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZTE1OWQ5NmRmNzZiYjBkOWNmNGI1YTU2MjIwOTBmOSIsInN1YiI6IjY1MTk0NWY2OTZlMzBiMDEwMDAyZjBlNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.27ffnBULdtVq7oYlxsEHHdjH44f5B1Tx8GdqwkJMmTU\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = true
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
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.10")

    //room
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    //coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.room:room-ktx:2.6.1")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")

    implementation("net.zetetic:android-database-sqlcipher:4.4.0")
    implementation("androidx.sqlite:sqlite-ktx:2.4.0")

    testImplementation("org.mockito:mockito-core:5.6.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")

    //special testing
    testImplementation("androidx.arch.core:core-testing:2.2.0") // InstantTaskExecutorRule
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3") //TestDispatcher

    //special instrumentation testing
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0") // InstantTaskExecutorRule
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3") //TestCoroutineDispatcher
    debugImplementation("androidx.fragment:fragment-testing:1.7.1") //launchFragmentInContainer
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:3.0.2") //RecyclerViewActions

}