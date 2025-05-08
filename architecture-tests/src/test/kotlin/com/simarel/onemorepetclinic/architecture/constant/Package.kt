package com.simarel.onemorepetclinic.architecture.constant

enum class Package(val value: String) {
    BASE("com.simarel.onemorepetclinic"),
    DOMAIN("$BASE.domain.."),
    APPLICATION("$BASE.application.."),
    PORT_INPUT("$BASE.port.input.."),
    PORT_OUTPUT("$BASE.port.output.."),
    ADAPTER_INPUT("$BASE.adapter.input.."),
    ADAPTER_OUTPUT("$BASE.adapter.output.."),
    BOOTSTRAP("$BASE.bootstrap..")
    ;

    override fun toString() = value
}
