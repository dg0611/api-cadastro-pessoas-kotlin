package com.api.cadastro.pessoa.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String = "",
    val email: String = "",

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    var telefone: MutableList<Telefone> = mutableListOf()
)
