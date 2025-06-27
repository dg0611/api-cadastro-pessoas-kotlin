package com.api.cadastro.pessoa.model

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Telefone(
    val numero: String,
    val tipo: String,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    val pessoa: Pessoa? = null

)
