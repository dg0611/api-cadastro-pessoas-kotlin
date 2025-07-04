package com.api.cadastro.pessoa.controller

import com.api.cadastro.pessoa.dto.request.PessoaRequestDTO
import com.api.cadastro.pessoa.dto.response.PessoaResponseDTO
import com.api.cadastro.pessoa.model.Pessoa
import com.api.cadastro.pessoa.service.PessoaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/pessoa")
class PessoaController(private val service: PessoaService) {

    @PostMapping
    fun cadastrarPessoa(@RequestBody formPessoa: PessoaRequestDTO): ResponseEntity<PessoaResponseDTO> {
        val pessoaCriada = service.cadastrar(formPessoa)
        val url: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()  // Pega a URL atual, ex: /pessoas
            .path("/{id}") // Adiciona /{id}
            .buildAndExpand(pessoaCriada.id) // Substitui {id} com o ID cadastrado
            .toUri()
        return ResponseEntity.created(url).body(pessoaCriada)
    }
}