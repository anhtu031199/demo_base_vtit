object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.androidGradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val ktLint by lazy { "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlintGradlePlugin}" }
    val navigationSafe by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }
    val googleServices by lazy { "com.google.gms:google-services:${Versions.googleServices}" }
}

object Versions {
    const val minSdkVersion = 26
    const val compileSdkVersion = 32
    const val targetSdkVersion = 32

    const val androidGradlePlugin = "7.1.3"
    const val kotlinGradlePlugin = "1.6.10"
    const val ktlintGradlePlugin = "10.2.1"
    const val googleServices = "4.3.13"
    const val firebaseCrashlyticsGradle = "2.8.1"

    const val corektx = "1.7.0"
    const val appcompat = "1.5.1"
    const val fragment = "1.4.1"
    const val lifecycle = "2.5.1"
    const val navigation = "2.5.3"
    const val material = "1.7.0"
    const val constraintLayout = "2.1.4"
    const val swiperefreshlayout = "1.1.0"
    const val recyclerview = "1.2.1"
    const val startupRuntime = "1.1.0"
    const val multidex = "2.0.1"
    const val koin = "2.2.2"
    const val hilt = "2.38.1"

    const val rxpermissions = "0.12"

    const val room = "2.4.3"
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val loggingInterceptor = "4.9.3"
    const val okhttpUrlconnection = "4.9.3"
    const val rxAndroid2 = "2.1.1"
    const val rxAndroid3 = "3.0.0"
    const val rxAdapter3 = "3.0.0"
    const val rxkotlin = "3.0.1"
    const val coroutines = "1.5.2"
    const val annotationAPI = "1.3.2"

    const val glide = "4.14.2"
    const val glideTransformation = "4.3.0"
    const val coil = "1.3.2"

    const val sspAndroid = "1.0.6"
    const val sdpAndroid = "1.0.6"
    const val timeJoda = "2.10.14"
    const val timber = "5.0.1"
    const val facebook = "13.1.0"
    const val ultimateBarX = "v0.8.0"

    const val agora = "3.6.0.1"
    const val progressview = "1.0.1"
    const val arcSeekBar = "0.34"
    const val advancedWebView = "v3.0.0"

    const val leakcanary = "2.8.1"
    const val chucker = "3.5.2"
    const val hyperion = "0.9.34"

    const val junit = "4.+"
    const val junitExt = "1.1.3"
    const val espressoCore = "1.1.3"
    const val robolectric = "4.7.3"
    const val spinkit = "1.4.0"
    const val viewPager = "1.0.0"
    const val locationServices = "21.0.1"
    const val sweetDialog = "1.6.2"
    const val cardview = "1.0.0"
    const val easyPermission = "3.0.0"
}

object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
    const val ktlintGradlePlugin =
        "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlintGradlePlugin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    const val firebaseCrashlyticsGradle =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradle}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinGradlePlugin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinGradlePlugin}"

    const val corektx = "androidx.core:core-ktx:${Versions.corektx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val navigationfragmentktx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationuiktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val startupRuntime = "androidx.startup:startup-runtime:${Versions.startupRuntime}"

    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val annotationAPI = "javax.annotation:javax.annotation-api:${Versions.annotationAPI}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val okhttpUrlconnection =
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttpUrlconnection}"
    const val rxAndroid2 = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid2}"
    const val rxAndroid3 = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid3}"
    const val rxAdapter3 = "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.rxAdapter3}"
    const val rxkotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxkotlin}"
    const val rxpermissions = "com.github.tbruyelle:rxpermissions:${Versions.rxpermissions}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideTransformation =
        "jp.wasabeef:glide-transformations:${Versions.glideTransformation}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val sdpAndroid = "com.intuit.sdp:sdp-android:${Versions.sdpAndroid}"
    const val sspAndroid = "com.intuit.ssp:ssp-android:${Versions.sspAndroid}"

    const val timeJoda = "net.danlew:android.joda:${Versions.timeJoda}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val facebook = "com.facebook.android:facebook-android-sdk:${Versions.facebook}"
    const val ultimateBarX = "com.gitee.zackratos:UltimateBarX:${Versions.ultimateBarX}"

    const val agora = "io.agora.rtc:full-sdk:${Versions.agora}"
    const val progressview = "com.shimaami.android:progressview:${Versions.progressview}"
    const val arcSeekBar = "com.github.marcinmoskala:ArcSeekBar:${Versions.arcSeekBar}"
    const val advancedWebView =
        "com.github.delight-im:Android-AdvancedWebView:${Versions.advancedWebView}"

    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
    const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
    const val hyperionCore = "com.willowtreeapps.hyperion:hyperion-core:${Versions.hyperion}"
    const val hyperionAttr = "com.willowtreeapps.hyperion:hyperion-attr:${Versions.hyperion}"
    const val hyperionBuildConfig =
        "com.willowtreeapps.hyperion:hyperion-build-config:${Versions.hyperion}"
    const val hyperionMeasurement =
        "com.willowtreeapps.hyperion:hyperion-measurement:${Versions.hyperion}"
    const val hyperionPhoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:${Versions.hyperion}"
    const val hyperionRecorder =
        "com.willowtreeapps.hyperion:hyperion-recorder:${Versions.hyperion}"
    const val hyperionSharedPreferences =
        "com.willowtreeapps.hyperion:hyperion-shared-preferences:${Versions.hyperion}"
    const val spinkit = "com.github.ybq:Android-SpinKit:${Versions.spinkit}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val viewPager = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
    const val locationServices =
        "com.google.android.gms:play-services-location:${Versions.locationServices}"
    const val sweetDialog = "com.github.f0ris.sweetalert:library:${Versions.sweetDialog}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val easyPermission = "pub.devrel:easypermissions:${Versions.easyPermission}"
}

object TestDeps {
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
}

