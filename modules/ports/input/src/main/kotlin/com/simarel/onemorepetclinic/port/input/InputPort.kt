package com.simarel.onemorepetclinic.port.input

fun interface InputPort<IN: InInputParam, OUT: OutInputParam> {
    fun invoke(request: IN): OUT
}

interface InInputParam
interface OutInputParam