package com.abel.anothertest.Utils

fun isValidCPF(cpf: String): Boolean {
    val numbers = cpf.filter { it.isDigit() }
    return numbers.length == 11
}