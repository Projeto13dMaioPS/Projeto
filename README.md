# Projeto 13 de Maio

Esse é o repositório do sistema desenvolvido pelo grupo **Leonardo, Germano e  Vinicius**, um projeto web construído com Java e Spring Boot.

## Sobre o projeto

A aplicação é um sistema web completo, com backend em Java e interface renderizada pelo Thymeleaf ( html ), conectada a um banco de dados MySQL ( JPA ). A ideia foi criar uma solução simples funcional, como um catalogo das obras presentes no museu, podendo o usuario (logado) ter sua propria lista de interesse! para caso queira visitar o museu, ja tendo base um catalogo.E para funcionarios funcionalidades para cadastro de itens, gerenciamento de usuarios e etc.

## Tecnologias utilizadas

- **Java 17**
- **Spring Boot 4.0.6**
- **Spring MVC** — para o roteamento e controle das requisições
- **Spring Data JPA** — para a comunicação com o banco de dados
- **Thymeleaf** — para os templates HTML das páginas
- **MySQL** — banco de dados relacional
- **Maven** — gerenciamento de dependências e build

## Estrutura do projeto

```
src/
├── main/
│   ├── java/        # Código Java (controllers, services, models, repositories)
│   └── resources/   # FrontEnd, configurações
└── test/            # Testes automatizados
```

## Branches

O repositório possui a branch `base`, desenvolvimento em andamento do projeto, e a branch `main` com o projeto final ( atual )

---

Projeto desenvolvido como trabalho acadêmico pelo grupo Leonardo, Germano e Vinicius.
