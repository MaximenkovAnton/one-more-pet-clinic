plugins {
    kotlin("jvm")
    jacoco
}

dependencies {
    // Зависимости от всех модулей проекта, кроме bootstrap
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":port-input"))
    implementation(project(":port-output"))
    implementation(project(":adapter-input"))
    implementation(project(":adapter-output"))
    
    // ArchUnit
    testImplementation("com.tngtech.archunit:archunit-junit5:1.2.0")
    
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
