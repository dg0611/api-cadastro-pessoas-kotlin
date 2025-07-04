package com.api.cadastro.pessoa.mapper

interface Mapper<T, V> {
    fun mapper(t: T): V
}