# Digital Innovation One: Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot. 

## Sistema de Gerenciamento de Pessoas

Durante a sessão,  foram desenvolvidos e abordados os seguintes tópicos:

1. Setup inicial de projeto com o Spring Boot Initialzr

2. Criação de modelo de dados para o mapeamento de entidades em bancos de dados

3. Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).

4. Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto.

5. Desenvolvimento de testes unitários para validação das funcionalidades
   Implantação do sistema na nuvem através do Heroku.

   

### Desafios encontrados durante o processo.

Alguns ajustes foram necessários serem realizados nas dependências do pom.xml. Não consegui importar o @NotNull, @NotEmpty e @Valid. Na qual utilizei a seguinte dependência de validação:

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

O motivo segundo informações é que teve uma mudança a partir da versão 2.5, sendo que agora precisa adicionar essa dependência separada para realizar as validações.

A segunda dificuldade que enfrentei foi em relação ao MapStruct no Intellij na qual a versão apontada durante o curso (1.3.1.Final) estava provocando erro de NullPointerException. A solução foi atualizar o MapStruct com a versão 1.4.2.Final. As orientações de como proceder segue no seguinte link: https://stackoverflow.com/questions/65112406/intellij-idea-mapstruct-java-internal-error-in-the-mapping-processor-java-lang

A terceira dificuldade foi de Plugin not found no maven. Na qual tive que utilizar a seguinte dependência:

```
    <!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin -->
    <dependency>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
    </dependency>
```

O que acabou dando certo no andamento do código.



### Considerações

Foi algo novo na qual nunca tinha trabalho antes. Exigiu muita pesquisa para superar os desafios, além das orientações de como proceder com algumas ferramentas como Heroku, Postman e o próprio Intellij na qual foi a primeira vez que os utilizei. A parte de testes não executou como o desejado com algumas implementações sugeridas durante o processo de desenvolvimento do projeto, na qual irei analisar e buscar outros caminhos para solucionar o ocorrido.
