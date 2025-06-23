# 📱 API de Cadastro de Pessoas com Telefones

Este é um projeto em Kotlin com Spring Boot que fornece uma API REST para cadastro de pessoas e seus respectivos telefones, com autenticação JWT e segurança via Spring Security + BCrypt.

---

## 🚀 Tecnologias Utilizadas

- Kotlin
- Spring Boot
- Spring Security
- JWT (Json Web Token)
- BCrypt (criptografia de senhas)
- JPA / Hibernate
- H2 Database (modo memória)
- Maven

---

## 🔒 Funcionalidades

- Cadastro de usuários com senha criptografada
- Login e geração de token JWT
- Autorização com base em roles (USER, ADMIN)
- Cadastro, listagem, detalhamento e remoção de pessoas e telefones
- Relacionamento @OneToMany / @ManyToOne entre Pessoa e Telefone
- Uso de DTOs para entrada e saída de dados

---

## 📂 Estrutura do Projeto

```plaintext
src/main/kotlin/com/example/seuprojeto
├── config/                 # Configurações de segurança
├── controller/             # Endpoints REST
├── dto/                    # DTOs de entrada e saída
├── exception/              # Tratamento global de exceções
├── model/                  # Entidades do banco
├── repository/             # Interfaces de persistência
├── security/               # JWT e filtros de autenticação/autorização
├── service/                # Regras de negócio
└── SeuProjetoApplication.kt

✨ Autor

Desenvolvido por Diego Gonçalves
