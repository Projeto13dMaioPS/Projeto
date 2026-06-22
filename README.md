# Projeto 13 de Maio PS

Esse é o repositório do sistema desenvolvido pelo grupo **13 de Maio**, um projeto web construído com Java e Spring Boot.

## Sobre o projeto

A aplicação é um sistema web completo, com backend em Java e interface renderizada pelo Thymeleaf, conectada a um banco de dados MySQL. A ideia foi criar uma solução funcional, com separação clara entre a lógica de negócio e a apresentação das páginas.

## Tecnologias utilizadas

- **Java 17**
- **Spring Boot 4.0.6**
- **Spring MVC** — para o roteamento e controle das requisições
- **Spring Data JPA** — para a comunicação com o banco de dados
- **Thymeleaf** — para os templates HTML das páginas
- **MySQL** — banco de dados relacional
- **Maven** — gerenciamento de dependências e build

## Como rodar o projeto

Antes de tudo, você vai precisar ter instalado:

- Java 17 ou superior
- Maven
- MySQL rodando localmente

Depois, clone o repositório e configure o banco de dados no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

Com tudo configurado, rode o projeto com:

```bash
./mvnw spring-boot:run
```

A aplicação vai subir em `http://localhost:8080`.

## Estrutura do projeto

```
src/
├── main/
│   ├── java/        # Código Java (controllers, services, models, repositories)
│   └── resources/   # Templates Thymeleaf, configurações
└── test/            # Testes automatizados
```

## Branches

O repositório possui a branch `base`, que contém a estrutura inicial do projeto, e a branch `main` com o desenvolvimento em andamento.

---

Projeto desenvolvido como trabalho acadêmico pelo grupo 13 de Maio.
