package com.simarel.onemorepetclinic.port.input

fun interface InputPort<IN, OUT> {
    fun invoke(request: IN): OUT
}
