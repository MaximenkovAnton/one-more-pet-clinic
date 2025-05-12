package com.simarel.onemorepetclinic.domain.exception

abstract class NotFoundException(message: String) : PetClinicException(message)

class OwnerNotFoundException : NotFoundException("Владелец не найден")
class PetNotFoundException : NotFoundException("Питомец не найден")
class VetNotFoundException : NotFoundException("Ветеринар не найден")
class VisitNotFoundException : NotFoundException("Визит не найден")
