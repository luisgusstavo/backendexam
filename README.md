# Avaliação de desenvolvedor backend Attornatus
Este projeto é fruto do desafio proposto pela Attornatus para o Cargo de Backend Developer
## Desafio
o desafio exigia a elaboração de uma API REST simples que realizasse as seguintes operações:
 
    1. Criar uma pessoa
    2. Editar uma pessoa
    3. Consultar uma pessoa
    4. Listar pessoas
    5. Criar endereço para pessoa
    6. Listar endereços da pessoa
    7. Poder informar qual endereço é o principal da pessoa  

## Solução
A solução foi elaborada utilizando as seguintes dependências:
 
    • Spring Web
    • Spring Data JPA
    • Rest Repositories
    • H2 Database

## Operações implementadas  

    1. Criar uma pessoa
    Para criar uma pessoa basta chamar o método POST passando os dados da pessoa em JSON para:
    http://localhost:8080/pessoas
    Exemplo de JSON:
    {
    "nome":"Luis Gustavo",
    "dataNasc":"1996-06-16"
    }
    
    2. Editar uma pessoa
    Para editar uma pessoa de id={id} basta chamar o método PATCH passando os campos que serão modificados em JSON para:
    http://localhost:8080/pessoas/{id}

    3. Consultar uma pessoa
    Para consultar uma pessoa basta chamar o método GET passando o {id} da pessoa para:
    http://localhost:8080/pessoas/{id}
    
    4. Listar pessoas
    Para listar as pessoas basta chamar o método GET em:
    http://localhost:8080/pessoas
    
    5. Criar endereço para pessoa
    Para criar um endereço para uma pessoa com id={id} basta chamar o método POST com as informações da pessoa em JSON para:
    http://localhost:8080/enderecos
    Exemplo de JSON:
    {
    "logradouro": "Av. Paulista",
    "cep": "01310200",
    "principal":true,
    "numero": "1678",
    "cidade": "São Paulo",
    "pessoa":"http://localhost:8080/pessoas/{id}"
    }   
    
    6. Listar endereços da pessoa
    Para listar os endereços vinculados a uma pessoa com id={id} basta chamar o método GET em:
    http://localhost:8080/enderecos/search/findByPessoaId?id={id}
    
    7. Poder informar qual endereço é o principal da pessoa
    Para consultar o endereço principal de uma pessoa com id={id} basta chamar o método GET em:
    http://localhost:8080/enderecos/search/findEnderecoPrincipal?id={id}
   
