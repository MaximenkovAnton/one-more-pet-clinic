package com.simarel.onemorepetclinic.architecture

import com.simarel.onemorepetclinic.architecture.constant.KnownFolder
import com.simarel.onemorepetclinic.architecture.constant.Package
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.jupiter.api.Test

class ApplicationArchitectureTest : BaseArchitectureTest() {

    @Test
    fun `application should only depend on domain and port`() {
        val rule = classes().that().resideInAPackage(Package.APPLICATION.toString())
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                Package.APPLICATION.toString(),
                Package.DOMAIN.toString(),
                Package.PORT_INPUT.toString(),
                Package.PORT_OUTPUT.toString(),
                KnownFolder.JAVA.toString(),
                KnownFolder.KOTLIN.toString(),
                KnownFolder.JETBRAINS_ANNOTATIONS.toString()
            )

        rule.check(allClasses)
    }
}
