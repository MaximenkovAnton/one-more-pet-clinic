package com.simarel.onemorepetclinic.domain.valueobject

@JvmInline
value class MiddleName private constructor(override val value: String) : ValueObject<String> {
    companion object {
        fun of(value: String?): MiddleName {
            return MiddleName(value ?: "")
        }
    }
}
