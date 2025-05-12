package com.simarel.onemorepetclinic.architecture

import com.simarel.onemorepetclinic.architecture.constant.Package
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class AdapterArchitectureTest : BaseArchitectureTest() {

    @Test
    fun `adapter-input should not depend on bootstrap and adapter-output`() {
        val rule = noClasses().that().resideInAPackage(Package.ADAPTER_INPUT.toString())
            .should().dependOnClassesThat().resideInAPackage(Package.BOOTSTRAP.toString())
            .andShould().dependOnClassesThat().resideInAPackage(Package.ADAPTER_OUTPUT.toString())

        rule.check(allClasses)
    }

    @Test
    fun `adapter-output should not depend on bootstrap and adapter-input`() {
        val rule = noClasses().that().resideInAPackage(Package.ADAPTER_OUTPUT.toString())
            .should().dependOnClassesThat().resideInAPackage(Package.BOOTSTRAP.toString())
            .andShould().dependOnClassesThat().resideInAPackage(Package.ADAPTER_INPUT.toString())

        rule.check(allClasses)
    }
}
