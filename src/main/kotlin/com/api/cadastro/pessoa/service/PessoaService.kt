package com.api.cadastro.pessoa.service

import com.api.cadastro.pessoa.dto.request.PessoaRequestDTO
import com.api.cadastro.pessoa.dto.response.PessoaResponseDTO
import com.api.cadastro.pessoa.mapper.PessoaRequestMapperDTO
import com.api.cadastro.pessoa.mapper.PessoaResponseMapperDTO
import com.api.cadastro.pessoa.model.Pessoa
import com.api.cadastro.pessoa.repository.PessoaRepository
import org.springframework.stereotype.Service

@Service
class PessoaService(
    private val repository: PessoaRepository,
    private val pessoaRequestMapperDTO: PessoaRequestMapperDTO,
    private val pessoaResponseMapperDTO: PessoaResponseMapperDTO
) {
    fun cadastrar(formPessoa: PessoaRequestDTO): PessoaResponseDTO {
        val pessoaCadastrada = repository.save(pessoaRequestMapperDTO.mapper(formPessoa))
        return pessoaResponseMapperDTO.mapper(pessoaCadastrada)
    }

}
