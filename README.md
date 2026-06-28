# Museu Digital

Um sistema web desenvolvido para facilitar a consulta ao acervo de um museu. A ideia é que qualquer pessoa consiga conhecer as obras antes mesmo de visitar o museu, pesquisando informações, criando uma lista de favoritos e planejando melhor a visita.

Além disso, o sistema também possui uma área administrativa para que o acervo possa ser gerenciado de forma simples e organizada.

---

## Qual era o problema?

Muitas pessoas acabam indo ao museu sem saber exatamente o que vão encontrar. Em alguns casos, elas nem conhecem o acervo disponível ou deixam de visitar obras que poderiam ser do interesse delas.

Além disso, manter esse acervo organizado apenas de forma manual acaba dificultando a atualização das informações e o gerenciamento das obras.

---

## Nossa solução

Desenvolvemos um catálogo digital onde o visitante pode navegar pelo acervo do museu antes da visita presencial.

No sistema é possível pesquisar obras, visualizar detalhes, descobrir informações sobre os autores e salvar as obras favoritas. Assim, quando chegar ao museu, o visitante já tem uma ideia do que deseja conhecer.

Enquanto isso, a equipe do museu pode manter todo o catálogo atualizado através de uma área administrativa.

---

## Funcionalidades

### Visitante

* Consultar o acervo
* Pesquisar obras
* Filtrar resultados
* Visualizar detalhes das obras
* Criar conta

### Usuário Logado

* Fazer login
* Adicionar obras aos favoritos
* Visualizar lista de favoritos
* Gerenciar perfil

### Administração

* Gerenciar Obras
* Gerenciar usuários
  
---

## Tecnologias utilizadas

* Java
* Spring Boot
* Thymeleaf
* Bootstrap
* MySQL
* Maven
* Git
* GitHub

---

## Arquitetura

O projeto foi desenvolvido utilizando o padrão MVC (Model-View-Controller), deixando cada parte do sistema bem organizada e facilitando futuras manutenções e melhorias.

---

## Como executar

1. Clone este repositório.
2. Abra o projeto na sua IDE.
3. Configure o banco de dados.
4. Execute a aplicação.
5. Acesse o sistema pelo navegador.

---

## Tecnologias utilizadas

- **Java 17**

- **Spring Boot 4.0.6**

- **Spring MVC** — para o roteamento e controle das requisições

- **Spring Data JPA** — para a comunicação com o banco de dados

- **Thymeleaf** — para os templates HTML das páginas

- **MySQL** — banco de dados relacional

- **Maven** — gerenciamento de dependências e build

---

## Estrutura do projeto

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/           # Controladores da aplicação
│   │   │   ├── service/              # Regras de negócio
│   │   │   ├── repository/           # Acesso ao banco de dados
│   │   │   ├── model/                # Entidades do sistema
│   │   │   └── ProjetoSTmApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   │
│   └── test/
│
├── documentacao/    # Diagramas e documentação do projeto
├── pom.xml          # Dependências e configuração do Maven
├── README.md
├── .gitignore
└── mvnw

```

## Quadro de atividades do grupo ( Kanban )

Voce pode acompanhar o desenvolvimento pelo quadro de atividades do grupo, com oque tem que seer feito, oque esta em revisao e oque ja foi implementado !

segue o link abaixo:

`https://github.com/orgs/Projeto13dMaioPS/projects/1`

---

Na pasta **documentaçao** estão todos os diagramas desenvolvidos durante o projeto, incluindo Casos de Uso, Diagrama de Domínio, Diagrama de Classes e Diagramas de Sequência.

---

## Equipe

* Leonardo Vasconcelos Corrêa
* Germano Spall
* Vinicius

---

## Vídeo demonstrativo

Link do vídeo:

""em desenvolvimento""

---

## Considerações finais

Esse projeto foi uma oportunidade muito boa pra colocar em prática os conteúdos vistos durante a disciplina. Durante o desenvolvimento fomos ajustando várias ideias, melhorando funcionalidades e organizando melhor o sistema conforme ele ia evoluindo.

O resultado foi um catálogo digital que ajuda tanto os visitantes, que conseguem conhecer melhor o acervo antes da visita, quanto a equipe do museu, que passa a ter um gerenciamento muito mais organizado das obras.
