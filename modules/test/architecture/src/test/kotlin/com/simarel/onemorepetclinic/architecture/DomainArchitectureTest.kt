package com.simarel.onemorepetclinic.architecture

import com.simarel.onemorepetclinic.architecture.constant.KnownFolder
import com.simarel.onemorepetclinic.architecture.constant.Package
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.jupiter.api.Test

class DomainArchitectureTest : BaseArchitectureTest() {
    @Test
    fun `domain should only depend on standard Java or Kotlin libraries`() {
        val rule = classes().that().resideInAPackage(Package.DOMAIN.toString())
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                Package.DOMAIN.toString(),
                KnownFolder.JAVA.toString(),
                KnownFolder.KOTLIN.toString(),
                KnownFolder.JETBRAINS_ANNOTATIONS.toString()
            )

        rule.check(allClasses)
    }
}
