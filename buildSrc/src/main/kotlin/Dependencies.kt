import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    val springBoot = listOf(
        "org.springframework.boot:spring-boot:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-autoconfigure:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-starter:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-starter-json:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-starter-logging:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-starter-tomcat:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-starter-security:${Versions.springBoot}",
    )
    val springBootJpa = "org.springframework.boot:spring-boot-starter-data-jpa:${Versions.springBoot}"
    val springBootBatch = "org.springframework.boot:spring-boot-starter-batch:${Versions.springBoot}"
    val springBootTest = listOf(
        "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-test:${Versions.springBoot}",
        "org.springframework.boot:spring-boot-test-autoconfigure:${Versions.springBoot}",
    )


    val spring = listOf(
        "org.springframework:spring-aop:${Versions.spring}",
        "org.springframework:spring-beans:${Versions.spring}",
        "org.springframework:spring-context:${Versions.spring}",
        "org.springframework:spring-core:${Versions.spring}",
        "org.springframework:spring-expression:${Versions.spring}",
        "org.springframework:spring-jcl:${Versions.spring}",
        "org.springframework:spring-web:${Versions.spring}",
        "org.springframework:spring-webmvc:${Versions.spring}",
    )
    val sprintTest = "org.springframework:spring-test:${Versions.spring}"
    val springBatchTest = listOf(
        "org.springframework.batch:spring-batch-test:${Versions.springBatch}"
    )

	val kotlinStdlib = listOf(
		"org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}",
		"org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}",
		"org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}",
		"org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}",
		"org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}",
		"org.jetbrains.kotlin:kotlin-scripting-compiler-embeddable:${Versions.kotlin}",
		"org.jetbrains.kotlin:kotlin-sam-with-receiver:${Versions.kotlin}",
	)
    val jwt = listOf(
        "io.jsonwebtoken:jjwt:${Versions.jwt}"
    )
    val jaxb = listOf(
        "javax.xml.bind:jaxb-api:${Versions.jaxb}"
    )
    val jackson = listOf(
        "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}",
        "com.fasterxml.jackson.module:jackson-module-parameter-names:${Versions.jackson}",
        "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.jackson}",
        "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jackson}",
        "com.fasterxml.jackson.core:jackson-core:${Versions.jackson}",
        "com.fasterxml.jackson.core:jackson-databind:${Versions.jacksonDatabind}",
        "com.fasterxml.jackson.core:jackson-annotations:${Versions.jackson}"
    )
    val lombok = "org.projectlombok:lombok:${Versions.lombok}"
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}