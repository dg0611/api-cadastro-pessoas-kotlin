package com.api.cadastro.pessoa.mapper

import com.api.cadastro.pessoa.dto.response.PessoaResponseDTO
import com.api.cadastro.pessoa.model.Pessoa
import org.springframework.stereotype.Component

@Component
class PessoaResponseMapperDTO : Mapper<Pessoa, PessoaResponseDTO> {
    override fun mapper(t: Pessoa): PessoaResponseDTO {
        return PessoaResponseDTO(
            id = t.id,
            nome = t.nome,
            email = t.email,
            telefone = t.telefone
        )
    }
}