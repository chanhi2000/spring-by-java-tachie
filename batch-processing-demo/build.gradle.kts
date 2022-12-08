plugins {
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.springBootDepMan
    kotlin("jvm")
    kotlin("plugin.spring") version Versions.kotlin
    kotlin("plugin.jpa") version Versions.kotlin
}

group = "com.example.markiimark"
version = Versions.Project.BATCH_PROCESSING_DEMO

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
    implementation(Dependencies.springBoot)
    implementation(Dependencies.springBootJpa)
    implementation(Dependencies.jackson)
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.springBootBatch)
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation(Dependencies.springBootTest)
    testImplementation(Dependencies.springBatchTest)
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
