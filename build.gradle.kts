import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.kotlin
}

allprojects {
    repositories {
        mavenCentral()
        maven {
          url = uri("https://plugins.gradle.org/m2/")
        }
    }

    tasks.withType<KotlinCompile> {
        sourceCompatibility = Versions.java
        targetCompatibility = Versions.java

        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = Versions.java
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}