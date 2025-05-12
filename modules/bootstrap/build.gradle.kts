plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":port-input"))
    implementation(project(":port-output"))
    implementation(project(":adapter-input"))
    implementation(project(":adapter-output"))

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.bootJar {
    archiveFileName.set("application.jar")
}
