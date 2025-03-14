# CodeAI 
Este documento tem como objetivo descrever os passos necessários para configuração do ambiente para o agente bem como para o modelo LLM.

## LLM (OLLAMA)
Para configurar o OLLAMA siga as instruções disponiveís nos links abaixo.

* [Ollama Site](https://ollama.com/download/linux)
* [Ollama GitHub](https://github.com/ollama/ollama/blob/main/docs/linux.md)

``Obs.:`` Adicionalmente, será necessário adicionar a configuração para definir a porta do serviço Ollama para 8080.

~~~sh
OLLAMA_HOST=0.0.0.0:8080
OLLAMA_MODELS=/mnt/.ollama/models

# /etc/systemd/system/ollama.service
...
Environment="PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin" "OLLAMA_HOST=0.0.0.0:8080" "OLLAMA_MODELS=/mnt/.ollama/models"
...
~~~

## CodeAI: Configuração do Agente 

Certifique que a VM possui:
* Java 17+
* Maven 3.1.1+

### Preparando diretórios
Por padrão realizamos as instalações no diretório ``/mnt``, mas não é uma obrigação e pode sofrer alteração de acordo com os padrões do cliente.

```sh
# Crie diretório raiz
$ mkdir /mnt/agents/codeai
$ sudo chmod 774 /mnt/agents/codeai
$ sudo chown codeai:codeai /mnt/agents/codeai
```

Acesse o diretório criado, pegue o executável ``unit-testing-2.1.0.jar`` e adicione no diretório.

Obs.: A copia do arquivo pode ser realizada via SSH, SFTP ou outra forma disponibilizada como por exemplo compartilhamento de rede.

```sh
$ /mnt/agents/codeai
$ ll
```

```txt
drwxrwxr--  4 codeai codeai     4096 Mar 10 14:44 ./
drwxr-xr-x  6 root    root        4096 Mar 10 14:11 ../
-rw-rw-r--  1 codeai codeai 74776411 Mar 10 12:07 unit-testing-2.1.0.jar
```

Nesse diretório, crie um arquivo executável para facilitar a execução do agente.

```sh
$ vim run-codeai.sh

# Conteudo ...
#!/bin/bash

export MAVEN_HOME=/mnt/tools/maven

java \
        -Dorchestrator.client.vcs.repository.URL=? \
        -Dorchestrator.client.vcs.accessToken=? \
        -Dorchestrator.client.vcs.repository.source-branch=main \
        -Dengine.ai.type=OLLAMA \
        -Dengine.ai.apiKey=TEMP_KEY_TO_BE_REPLACED_ONCE_AUTH_IN_PLACE \
        -Dengine.ai.apiUrl=? \
        -Dengine.ai.modelName=gemma2 \
        -jar unit-testing-2.1.0.jar

# Tornando executável
$ chmod +x run-codeai.sh
```

Abaixo apresento as propriedade de maior relevância e necessárias para uma execução padrão, para conhecer todas as opções acesse [documentação](https://capgemini.sharepoint.com/sites/CuttingEdgeCommunity/SitePages/Code-AI-user-manual.aspx).

| Propriedade   |      Descrição      |
| :------------ | :------------------ |
| orchestrator.client.vcs.repository.URL | Endereço do repositório de código fonte do projeto que será analizado |
| orchestrator.client.vcs.accessToken | Token necessário para permitir acesso ao repositório de código fonte |
| orchestrator.client.vcs.repository.source-branch | Branch qual será utilizada como base, por padrão vem com ```master``` |
| engine.ai.apiUrl | Endereço de API disponibilizada pelo modelo LLM, em nosso caso um Ollama Service |
| engine.ai.apiKey | Chave exigida pela API LLM para prover comunicação |

### Execução

```sh
$ export REPO_ACCESS_TOKEN=?
$ ./run-codeai.sh
```

## Referências

[CodeAI Page](https://capgemini.sharepoint.com/sites/CuttingEdgeCommunity/SitePages/codeai.aspx)