dependencies {
    api(project(":domain"))

    // Тестовые зависимости
    api("org.junit.jupiter:junit-jupiter-api:5.10.0")
    api("io.kotest:kotest-assertions-core:5.6.2")
    api("io.mockk:mockk:1.13.5")
}
