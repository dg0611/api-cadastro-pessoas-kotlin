package com.api.cadastro.pessoa.mapper

import com.api.cadastro.pessoa.dto.request.PessoaRequestDTO
import com.api.cadastro.pessoa.model.Pessoa
import org.springframework.stereotype.Component

@Component
class PessoaRequestMapperDTO : Mapper<PessoaRequestDTO, Pessoa> {
    override fun mapper(t: PessoaRequestDTO): Pessoa {
        val pessoa = Pessoa(
            nome = t.nome,
            email = t.email,
            telefone = t.telefone
        )
        //Garante que antes de salvar, cada telefone aponte para a instancia da entidade Pessoa.
        t.telefone.forEach { telefone ->
            telefone.pessoa = pessoa
        }
        pessoa.telefone = t.telefone
        return pessoa
    }

}