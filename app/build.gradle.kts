plugins {
    alias(libs.plugins.android.application)
}

open class DummyOutput(val resourcesDir: File)
open class DummySourceSet(val runtimeClasspath: FileCollection, val output: DummyOutput)
open class DummySourceSetContainer(val main: DummySourceSet) {
    fun getAt(name: String): DummySourceSet = main
    fun getByName(name: String): DummySourceSet = main
}

val extStorageField = project.extensions.javaClass.getDeclaredField("extensionsStorage")
extStorageField.isAccessible = true
val storageObj = extStorageField.get(project.extensions)
val extensionsMapField = storageObj.javaClass.getDeclaredField("extensions")
extensionsMapField.isAccessible = true
val extensionsMap = extensionsMapField.get(storageObj) as MutableMap<Any, Any>
extensionsMap.remove("sourceSets")

val dummySourceSet = DummySourceSet(
    files(
        layout.buildDirectory.dir("intermediates/javac/debug/compileDebugJavaWithJavac/classes"),
        layout.buildDirectory.dir("tmp/kotlin-classes/debug"),
        provider { configurations.named("debugRuntimeClasspath").get() }
    ),
    DummyOutput(layout.buildDirectory.dir("processed_res/debug/out").get().asFile)
)
extensions.add("sourceSets", DummySourceSetContainer(dummySourceSet))

android {
    namespace = "com.example.consoletestrun"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.consoletestrun"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}

tasks.addRule("Pattern: <ClassName>.main()") {
    val taskName = this
    if (taskName.endsWith(".main()")) {
        val className = taskName.substringBefore(".main()")
        tasks.register<JavaExec>(taskName) {
            description = "Runs the main method of class $className"
            group = "application"
            mainClass.set(className)
            classpath = files(
                layout.buildDirectory.dir("intermediates/javac/debug/compileDebugJavaWithJavac/classes"),
                layout.buildDirectory.dir("tmp/kotlin-classes/debug"),
                provider { configurations.named("debugRuntimeClasspath").get() }
            )
            dependsOn(tasks.matching { it.name == "compileDebugJavaWithJavac" || it.name == "compileDebugKotlin" })
            standardInput = System.`in`
        }
    }
}