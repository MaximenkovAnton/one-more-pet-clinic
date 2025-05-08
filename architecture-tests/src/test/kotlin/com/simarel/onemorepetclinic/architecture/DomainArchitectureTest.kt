package com.simarel.onemorepetclinic.architecture

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class DomainArchitectureTest : BaseArchitectureTest() {
    @Test
    fun `domain should only depend on standard Java or Kotlin libraries`() {
        val rule = classes().that().resideInAPackage(PACKAGES.DOMAIN.toString())
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                PACKAGES.DOMAIN.toString(),
                "java..",
                "kotlin..",
                "org.jetbrains.annotations..", // аннотации проставляет котлин, например при NotNull
            )
        
        rule.check(allClasses)
    }
}
