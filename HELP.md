# Primeiros Passos

### Documentação de Referência

Caso queira se aprofundar nas tecnologias utilizadas neste projeto, os links abaixo podem ajudar:

* [Documentação Oficial do Apache Maven](https://maven.apache.org/guides/index.html)
* [Guia de Referência do Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/4.0.6/maven-plugin)
* [Criando uma imagem OCI](https://docs.spring.io/spring-boot/4.0.6/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.6/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.6/reference/using/devtools.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html)

### Guias

Os materiais abaixo mostram, na prática, como utilizar alguns dos recursos empregados no desenvolvimento da aplicação:

* [Acessando dados com JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Acessando dados com MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Manipulando envio de formulários](https://spring.io/guides/gs/handling-form-submission/)
* [Construindo um serviço RESTful](https://spring.io/guides/gs/rest-service/)
* [Desenvolvendo aplicações Web com Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Construindo APIs REST com Spring](https://spring.io/guides/tutorials/rest/)

### Observação sobre o Maven Parent

Por padrão, o Maven herda diversas configurações do **Parent POM**. Isso facilita bastante a configuração do projeto, mas também faz com que alguns elementos, como `<license>` e `<developers>`, sejam herdados automaticamente.

Para evitar essas informações desnecessárias, este projeto possui sobrescritas vazias desses elementos no arquivo `pom.xml`. Caso o projeto passe a utilizar outro **Parent POM** e você queira manter essa herança, basta remover essas sobrescritas.
