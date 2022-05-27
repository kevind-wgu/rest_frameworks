package com.example.cc

fun main() {
    println(myMethod(1))
    println(myMethod(2))
    println(myMethod(3))
    println(myMethod(null))
    testIt {
        println("HI $this")
    }
}

fun myMethod(v: Int?): Int {
    val result = v?.let{v*2}
    if (result == null) {
        return 0
    }
    return result
}

fun testIt(stuff: Int.() -> Unit): Int {
    println("TestIt")
    stuff(1)
    return 1
}
