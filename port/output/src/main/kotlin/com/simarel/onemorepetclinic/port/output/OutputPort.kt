package com.simarel.onemorepetclinic.port.output

fun interface OutputPort<IN, OUT> {
    fun invoke(request: IN): OUT
}
