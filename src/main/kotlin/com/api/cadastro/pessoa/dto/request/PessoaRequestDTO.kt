package com.api.cadastro.pessoa.dto.request

import com.api.cadastro.pessoa.model.Telefone

data class PessoaRequestDTO(

    val nome: String,
    val email: String,
    val telefone: MutableList<Telefone> = mutableListOf()
)
