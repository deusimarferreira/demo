## Documentação do `pom.xml`

**1. Visão Geral:**

Este arquivo `pom.xml` é um arquivo de configuração para a ferramenta de compilação Maven, usado para definir e gerenciar o processo de construção de uma aplicação Spring Boot chamada "demo". Ele especifica metadados do projeto, dependências, plugins e outras configurações necessárias para compilar, testar, empacotar e implantar a aplicação.

**2. Ferramenta de Construção:** Maven

**3. Nome do Script/Arquivo:** pom.xml

**4. Documentação Detalhada:**

* **Metadados do Projeto:**
    - `<groupId>`: `com.example` - Identifica o grupo ou organização que possui o projeto.
    - `<artifactId>`: `demo` - Identificador único para o projeto dentro de seu grupo.
    - `<version>`: `0.0.1-SNAPSHOT` - Versão atual do projeto. "SNAPSHOT" indica que é uma versão de desenvolvimento.
    - `<name>`: `demo` - Nome legível por humanos do projeto.
    - `<description>`: `Demo project for Spring Boot` - Descrição breve do propósito do projeto.

* **Projeto Pai:**
    - `<parent>`: Define o projeto pai do qual este projeto herda configurações e dependências. Neste caso, ele usa o `spring-boot-starter-parent` fornecido pelo Spring Boot. Isso simplifica a gestão de dependências e garante compatibilidade com as convenções do Spring Boot.

* **Propriedades:**
    - `<properties>`: Contém pares chave-valor usados ​​em todo o arquivo POM. Aqui, `java.version` é definido como "17", especificando a versão do Java necessária para construir o projeto.

* **Dependências:**
    - `<dependencies>`: Lista todas as bibliotecas externas e módulos necessários pelo projeto. 
        -  `<dependency>`: Representa uma única dependência. Ele inclui:
            - `groupId`: Identificador único do grupo da biblioteca (por exemplo, `org.springframework.boot`).
            - `artifactId`: Nome da biblioteca específica (por exemplo, `spring-boot-starter-web`).
            - `scope`: Especifica a fase de ciclo de vida onde a dependência é usada (por exemplo, `runtime` para dependências necessárias durante a execução, `test` para testes).
            - `optional`: Indica se a dependência é opcional e pode ser excluída se não for necessária.

* **Plugins:**
    - `<plugins>`: Define plugins de compilação que estendem a funcionalidade do Maven. 
        -  `<plugin>`: Representa um único plugin. Ele inclui:
            - `groupId`: Identificador único do plugin (por exemplo, `org.apache.maven.plugins`).
            - `artifactId`: Nome do plugin específico (por exemplo, `maven-compiler-plugin`).
            - `<configuration>`: Contém configurações para o plugin.

**5. Versão da Linguagem:** Java 17

**6. Versões das Dependências:**

* Spring Boot Starter Parent: 3.4.3
* Spring Boot Starter Web: Última versão compatível com o pai
* Spring Boot DevTools: Última versão compatível com o pai
* Lombok: Última versão compatível com o pai
* Spring Boot Starter Test: Última versão compatível com o pai

**7. Código Falso:**

```
// Configuração do Projeto
Definir metadados do projeto (groupId, artifactId, version, name, description)
Especificar o projeto pai como "spring-boot-starter-parent"

// Dependências
Incluir dependências necessárias:
    - Spring Boot Starter Web para desenvolvimento web
    - Spring Boot DevTools para recarga quente durante o desenvolvimento (opcional)
    - Lombok para simplificação do código (opcional)
    - Spring Boot Starter Test para testes

// Plugins
Configurar o Plugin Maven Compiler:
    - Adicionar caminhos de processador de anotações para Lombok para habilitar sua funcionalidade.
Configurar o Plugin Maven Spring Boot:
    - Excluir a dependência Lombok da embalagem para evitar conflitos.


// Processo de Construção
Compilar o projeto usando Java 17
Testar a aplicação usando Spring Boot Starter Test
Empacotar a aplicação como um arquivo JAR

```

**8. Equivalentes de Dependências e Plugins:**

* **Maven:** Gradle é uma ferramenta alternativa popular de compilação com funcionalidade semelhante.



