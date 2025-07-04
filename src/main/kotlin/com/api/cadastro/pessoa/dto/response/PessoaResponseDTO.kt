package com.api.cadastro.pessoa.dto.response

import com.api.cadastro.pessoa.model.Telefone

data class PessoaResponseDTO(
    val id: Long? = null,
    val nome: String,
    val email: String,
    val telefone: MutableList<Telefone> = mutableListOf()
)
