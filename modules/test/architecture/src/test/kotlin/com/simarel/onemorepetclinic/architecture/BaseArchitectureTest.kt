package com.simarel.onemorepetclinic.architecture

import com.simarel.onemorepetclinic.architecture.constant.Package
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
            .importPackages(Package.BASE.toString())
    }
}
