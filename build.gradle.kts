/*
 * Developed by Ji Sungbin, 2022
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/dependency-graph-plugin/blob/main/LICENSE
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    `kotlin-dsl`
    `maven-publish`
}

group = "land.sungbin.dependency.graph"
version = "1.0.0"

configure<PublishingExtension> {
    publications.withType<MavenPublication> {
        artifactId = "dependency-graph-plugin"
    }
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("dependencyGraphPlugin") {
            id = "land.sungbin.dependency.graph.plugin"
            implementationClass = "DependencyGraphPlugin"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()
}