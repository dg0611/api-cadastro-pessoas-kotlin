package com.api.cadastro.pessoa.controller

import com.api.cadastro.pessoa.dto.request.PessoaRequestDTO
import com.api.cadastro.pessoa.dto.response.PessoaResponseDTO
import com.api.cadastro.pessoa.service.PessoaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/pessoa")
class PessoaController(private val service: PessoaService) {

    @GetMapping
    fun listarPessoas(): ResponseEntity<List<PessoaResponseDTO>> {
        val pessoas = service.listar()
        return ResponseEntity.ok(pessoas)
    }

    @GetMapping("/{id}")
    fun listarPessoaPorId(@PathVariable id: Long): ResponseEntity<PessoaResponseDTO> {
        val pessoa = service.listarPorId(id)
        return if (pessoa != null) {
            ResponseEntity.ok(pessoa)
        } else {
            ResponseEntity.notFound().build()
        }
    }

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

    @PutMapping("/{id}")
    fun atualizarPessoa(
        @PathVariable id: Long,
        @RequestBody formPessoa: PessoaRequestDTO
    ): ResponseEntity<PessoaResponseDTO> {
        val pessoaExistente = service.atualizar(id, formPessoa)
        if (pessoaExistente != null) {
            return ResponseEntity.ok(pessoaExistente)
        } else {
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletarPessoa(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.deletar(id)) {
            ResponseEntity.noContent().build()
        } else {
            return ResponseEntity.notFound().build()
        }
    }
}