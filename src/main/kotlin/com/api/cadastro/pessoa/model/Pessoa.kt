package com.api.cadastro.pessoa.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
data class Pessoa(
    val nome: String,
    val email: String,

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    val telefone: MutableList<Telefone> = mutableListOf()
)
