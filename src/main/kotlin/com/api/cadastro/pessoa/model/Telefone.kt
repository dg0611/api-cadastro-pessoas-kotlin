package com.api.cadastro.pessoa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
data class Telefone(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val numero: String = "",
    val tipo: String = "",

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonBackReference
    var pessoa: Pessoa? = null

)
