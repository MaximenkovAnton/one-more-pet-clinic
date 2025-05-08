package com.simarel.onemorepetclinic.architecture

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ApplicationArchitectureTest : BaseArchitectureTest() {
    
    @Test
    fun `application should only depend on domain and port`() {
        val rule = classes().that().resideInAPackage(PACKAGES.APPLICATION.toString())
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                PACKAGES.APPLICATION.toString(),
                PACKAGES.DOMAIN.toString(),
                PACKAGES.PORT_INPUT.toString(),
                PACKAGES.PORT_OUTPUT.toString(),
                "java..",
                "kotlin.."
            )
        
        rule.check(allClasses)
    }
}
