dependencies {
    implementation(project(":domain"))
    api(project(":port-input"))
    api(project(":port-output"))

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation(project(":test-utils-domain"))
}
