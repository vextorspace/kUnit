plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.ronnev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    jvmToolchain(21)
}