package com.simarel.onemorepetclinic.architecture

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class AdapterArchitectureTest : BaseArchitectureTest() {
    
    @Test
    fun `adapter-input should not depend on bootstrap`() {
        val rule = noClasses().that().resideInAPackage(PACKAGES.ADAPTER_INPUT.toString())
            .should().dependOnClassesThat().resideInAPackage(PACKAGES.BOOTSTRAP.toString())
            .andShould().dependOnClassesThat().resideInAPackage(PACKAGES.ADAPTER_OUTPUT.toString())

        rule.check(allClasses)
    }
    
    @Test
    fun `adapter-output should not depend on bootstrap`() {
        val rule = noClasses().that().resideInAPackage(PACKAGES.ADAPTER_OUTPUT.toString())
            .should().dependOnClassesThat().resideInAPackage(PACKAGES.BOOTSTRAP.toString())
            .andShould().dependOnClassesThat().resideInAPackage(PACKAGES.ADAPTER_INPUT.toString())
        
        rule.check(allClasses)
    }
}
