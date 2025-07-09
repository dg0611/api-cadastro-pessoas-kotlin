package com.api.cadastro.pessoa.service

import com.api.cadastro.pessoa.dto.request.PessoaRequestDTO
import com.api.cadastro.pessoa.dto.response.PessoaResponseDTO
import com.api.cadastro.pessoa.mapper.PessoaRequestMapperDTO
import com.api.cadastro.pessoa.mapper.PessoaResponseMapperDTO
import com.api.cadastro.pessoa.model.Pessoa
import com.api.cadastro.pessoa.model.Telefone
import com.api.cadastro.pessoa.repository.PessoaRepository
import org.springframework.stereotype.Service

@Service
class PessoaService(
    private val repository: PessoaRepository,
    private val pessoaRequestMapperDTO: PessoaRequestMapperDTO,
    private val pessoaResponseMapperDTO: PessoaResponseMapperDTO
) {

    fun listar(): List<PessoaResponseDTO> {
        return repository.findAll().map { pessoaResponseMapperDTO.mapper(it) }
    }

    fun listarPorId(id: Long): PessoaResponseDTO? {
        val pessoa = repository.findById(id).orElse(null)
        return pessoa?.let { pessoaResponseMapperDTO.mapper(it) }
    }

    fun cadastrar(formPessoa: PessoaRequestDTO): PessoaResponseDTO {
        val pessoaCadastrada = repository.save(pessoaRequestMapperDTO.mapper(formPessoa))
        return pessoaResponseMapperDTO.mapper(pessoaCadastrada)
    }

    fun atualizar(id: Long, formPessoa: PessoaRequestDTO): PessoaResponseDTO? {
        val pessoaExistente = repository.findById(id).orElse(null) ?: return null

        pessoaExistente.nome = formPessoa.nome
        pessoaExistente.email = formPessoa.email

        // Limpa telefones antigos
        pessoaExistente.telefone.clear()

        //Adiciona novos telefones
        formPessoa.telefone.forEach { telefone ->
            val telefone = Telefone(
                id = null,
                numero = telefone.numero,
                tipo = telefone.tipo,
                pessoa = pessoaExistente // Vincula a pessoa
            )
            pessoaExistente.telefone.add(telefone)
        }

        val pessoaAtualizada = repository.save(pessoaExistente)
        return pessoaResponseMapperDTO.mapper(pessoaAtualizada)
    }

    fun deletar(id: Long): Boolean {
        return repository.findById(id).map {
            repository.delete(it)
            true
        }.orElse(false)
    }

}
