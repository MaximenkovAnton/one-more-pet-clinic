package com.simarel.onemorepetclinic.test.utils.domain.factory

import com.simarel.onemorepetclinic.domain.valueobject.id.OwnerId
import com.simarel.onemorepetclinic.domain.valueobject.id.PetId
import com.simarel.onemorepetclinic.domain.valueobject.id.VetId
import com.simarel.onemorepetclinic.domain.valueobject.id.VisitId
import java.util.UUID

/**
 * Фабрика для создания идентификаторов сущностей в тестах
 */
object IdFactory {
    /**
     * Создает UUID для использования в идентификаторах
     */
    fun createUUID(): UUID = UUID.randomUUID()

    /**
     * Создает идентификатор владельца
     */
    fun createOwnerId(uuid: UUID = createUUID()): OwnerId = OwnerId.of(uuid)

    /**
     * Создает идентификатор питомца
     */
    fun createPetId(uuid: UUID = createUUID()): PetId = PetId.of(uuid)

    /**
     * Создает идентификатор ветеринара
     */
    fun createVetId(uuid: UUID = createUUID()): VetId = VetId.of(uuid)

    /**
     * Создает идентификатор визита
     */
    fun createVisitId(uuid: UUID = createUUID()): VisitId = VisitId.of(uuid)
}
