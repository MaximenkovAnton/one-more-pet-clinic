package com.simarel.onemorepetclinic.architecture

import com.simarel.onemorepetclinic.architecture.constant.KnownFolder
import com.simarel.onemorepetclinic.architecture.constant.Package
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ConditionEvents
import com.tngtech.archunit.lang.SimpleConditionEvent
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.jupiter.api.Test

class PortArchitectureTest : BaseArchitectureTest() {

    @Test
    fun `port input should only depend on domain`() {
        val rule = classes().that().resideInAnyPackage(Package.PORT_INPUT.toString())
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                Package.PORT_INPUT.toString(),
                Package.DOMAIN.toString(),
                KnownFolder.JAVA.toString(),
                KnownFolder.KOTLIN.toString(),
                KnownFolder.JETBRAINS_ANNOTATIONS.toString()
            )

        rule.check(allClasses)
    }

    @Test
    fun `port output should only depend on domain`() {
        val rule = classes().that().resideInAnyPackage(Package.PORT_OUTPUT.toString())
            .should().onlyDependOnClassesThat().resideInAnyPackage(
                Package.PORT_OUTPUT.toString(),
                Package.DOMAIN.toString(),
                KnownFolder.JAVA.toString(),
                KnownFolder.KOTLIN.toString(),
                KnownFolder.JETBRAINS_ANNOTATIONS.toString()
            )

        rule.check(allClasses)
    }

    @Test
    fun `port-input classes should be interfaces or DTOs`() {
        val rule = classes().that().resideInAPackage(Package.PORT_INPUT.toString())
            .should(beInterfaceOrDTO())

        rule.check(allClasses)
    }

    @Test
    fun `port-output classes should be interfaces or DTOs`() {
        val rule = classes().that().resideInAPackage(Package.PORT_OUTPUT.toString())
            .should(beInterfaceOrDTO())

        rule.check(allClasses)
    }

    private fun beInterfaceOrDTO(): ArchCondition<JavaClass> {
        return object : ArchCondition<JavaClass>("be interface or DTO") {
            override fun check(item: JavaClass, events: ConditionEvents) {
                val isInterface = item.isInterface
                val isDTO = !isInterface && (item.simpleName.endsWith("Request") || item.simpleName.endsWith("Response")) &&
                    hasOnlyGettersSettersAndConstructors(item)

                if (!isInterface && !isDTO) {
                    val message = "${item.name} is neither an interface nor a DTO"
                    events.add(SimpleConditionEvent(item, false, message))
                }
            }

            private fun hasOnlyGettersSettersAndConstructors(javaClass: JavaClass): Boolean {
                val methods = javaClass.methods
                return methods.all { method ->
                    method.name.startsWith("get") || method.name.startsWith("set") || method.name.startsWith("is") ||
                        method.name == "<init>" || // Конструктор
                        method.name.startsWith("component") || // Kotlin data class методы
                        method.name == "copy" ||
                        method.name == "equals" ||
                        method.name == "hashCode" ||
                        method.name == "toString"
                }
            }
        }
    }
}
