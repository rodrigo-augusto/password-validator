# Password Validator
Repositório com micro serviço java + spring boot para validação de senhas.

### Como usar?
1. Basta realizar o download do codigo (seja através de um checkout ou baixando o .zip do repositorio)
2. Importe o projeto baixado (caso tenha baixado um .zip, descompacte-o antes em alguma pasta de sua escolha) de **preferencia** através da IDE IntelliJ versao igual ou superiror à 2019.1.4 x64
3. Após a IDE baixar todas as dependencias, basta rodar localmente com o comando ":bootRun" (No caso de usar a IDE IntelliJ, basta dar um clique duplo no comando "Tasks -> application -> bootRun" dentro da aba "Gradle")

#### Informações adicionais:
1. A API esta disponivel online no seguinte link: [HerokuApp](https://simple-password-validator.herokuapp.com/)
2. Para usar a API é necessário passar um token de autenticação no header ("Authorization") de cada requisição, cujo valor é "admin" (usando o swagger, basta se autenticar através da opção "Authorize" no inicio da pagina do lado direito informando o valor do token)
3. Seu computador deve ter acesso a internet para que as dependencias sejam baixadas do repositorio maven (caso tenha recebido uma copia atraves de um pendrive)
