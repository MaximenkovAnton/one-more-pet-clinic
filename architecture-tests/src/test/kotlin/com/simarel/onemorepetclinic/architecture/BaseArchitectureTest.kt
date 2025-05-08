package com.simarel.onemorepetclinic.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseArchitectureTest {
    
    protected lateinit var allClasses: JavaClasses
    
    @BeforeAll
    fun setup() {
        allClasses = ClassFileImporter()
            .withImportOption(ImportOption.DoNotIncludeTests())
            .importPackages(PACKAGES.BASE.toString())
    }
    
    // Константы для пакетов
    enum class PACKAGES(val value: String) {
        BASE("com.simarel.onemorepetclinic"),
        DOMAIN("${BASE}.domain.."),
        APPLICATION("${BASE}.application.."),
        PORT_INPUT("${BASE}.port.input.."),
        PORT_OUTPUT("${BASE}.port.output.."),
        ADAPTER_INPUT("${BASE}.adapter.input.."),
        ADAPTER_OUTPUT("${BASE}.adapter.output.."),
        BOOTSTRAP("${BASE}.bootstrap.."),
        ;

        override fun toString() = value
    }
}
