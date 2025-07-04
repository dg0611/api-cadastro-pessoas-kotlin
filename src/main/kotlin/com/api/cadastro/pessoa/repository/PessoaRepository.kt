package com.api.cadastro.pessoa.repository

import com.api.cadastro.pessoa.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository : JpaRepository<Pessoa, Long> {
}