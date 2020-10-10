plugins {
    java
    }

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.70")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.70")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.4.RELEASE")
    implementation("org.postgresql:postgresql:42.2.10.jre7")
}

group = "io.github.olegvelikanov"
version = "1.0-SNAPSHOT"