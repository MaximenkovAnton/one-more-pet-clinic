package com.simarel.onemorepetclinic.architecture.constant

enum class KnownFolder(val value: String) {
    JAVA("java.."),
    KOTLIN("kotlin.."),
    JETBRAINS_ANNOTATIONS("org.jetbrains.annotations..") // аннотации проставляет котлин, например при NotNull
    ;

    override fun toString() = value
}
