import com.google.protobuf.gradle.id

plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("com.google.protobuf") version "0.9.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-all:4.1.100.Final")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("net.devh:grpc-server-spring-boot-starter:2.15.0.RELEASE")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    // Protobuf
    implementation("com.google.protobuf:protobuf-java:3.25.3")
    implementation("com.google.protobuf:protobuf-kotlin:3.25.3")

    // gRPC
    implementation("io.grpc:grpc-stub:1.67.1")
    implementation("io.grpc:grpc-protobuf:1.67.1")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
    implementation("io.grpc:grpc-netty-shaded:1.67.1")


    implementation("org.liquibase:liquibase-core")


    // PostgreSQL
    runtimeOnly("org.postgresql:postgresql")

    // Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test"))

    compileOnly("org.apache.tomcat:annotations-api:6.0.53")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.3"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.67.1"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.1:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                id("grpc")
                id("grpckt")
            }
            task.builtins {
                create("kotlin")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}

sourceSets {
    main {
        java {
            srcDir("build/generated/source/proto/main/java")
            srcDir("build/generated/source/proto/main/kotlin")
            srcDir("build/generated/source/proto/main/grpc")
        }
    }
}
