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

```
---
## 🧠Alguns Padrões de Projeto Utilizados

Este projeto segue os principais padrões e boas práticas para garantir organização, manutenibilidade e escalabilidade.

### Padrão Principal

- **MVC (Model-View-Controller) adaptado para API REST**  
  Organização clara em camadas:
  - **Model:** Entidades que representam os dados.  
  - **View:** Dados formatados para o cliente via DTOs (JSON).  
  - **Controller:** Recebe e responde às requisições HTTP.

### Outros Padrões Aplicados

| Padrão              | Descrição                                                                                     |
|---------------------|-----------------------------------------------------------------------------------------------|
| **DTO (Data Transfer Object)** | Abstração dos dados trafegados pela API, separando domínio da apresentação.           |
| **Repository**       | Abstração da camada de persistência com Spring Data JPA.                                    |
| **Service Layer**    | Centraliza as regras de negócio, isolando o controller da lógica e do acesso a dados.        |
| **Singleton**        | Beans gerenciados pelo Spring são instanciados uma única vez durante o ciclo da aplicação.    |
| **Strategy**         | Utilizado pelo Spring Security e JWT para diferentes formas de autenticação e autorização.   |

---
```
✨ Autor

Desenvolvido por Diego Gonçalves
```
