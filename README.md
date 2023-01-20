<div style="display: inline_block"><br>
  <img align="center" alt="Vitor-Java" height="40" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">
  <img align="center" alt="Vitor-Spring" height="40" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg">
  <img align="center" alt="Vitor-Spring" height="60" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-plain-wordmark.svg">
</div>

# Desafio 3 South System

API para gerenciar os dados de Produtos. É possível fazer a inclusão, alteração, consulta, listagem, importação e exclusão de Produtos.
Neste projeto mostraremos como armazenar Produtos no postgreSQL.

## Iniciar a aplicação
- Clone o repositório para sua máquina local.
- Abra o terminal pela sua IDE ou pelo seu Sistema Operacional(mas se direciona ao diretório do projeto clonado).
- Ainda no terminal utilize o comando: **docker-compose up -d** (para serem criadas as imagens e os containers).
- Para certificar conexão com banco de dados utilize o DBeaver passando as seguintes informações:
  - Host: localhost
  - Port: 5435
  - Database: DB_south
  - Username: postgres
  - Password: postgres

## Testes com Postman(Aplicação Product API)
- Primeiro importe no seu Postman a coleção: **South System Desafio 3.postman_collection.json** que foi passado dentro do diretório do proejto.
- A aplicação contém uma camada de segurança e foi utilizado o protocolo OAuth2, logo, as requisições da API exigem um token de segurança.
- Para conseguir o token vá na requisição **POST - token** da sua coleção, e copie o conteúdo que foi passado no campo "access_token" como mostra abaixo:

![alt text](https://github.com/Vitorsandrade/desafio-south-impulsionar/blob/main/images/access_token.png)

- para utilização de qualquer uma das requisições informe o token de acesso na aba **Authorization** da requisição, utilize o type **Bearer Token**
e informe o token que foi passado:(Válido apenas para a Prodcut Api)

![alt text](https://github.com/Vitorsandrade/desafio-south-impulsionar/blob/main/images/token_requisi%C3%A7%C3%A3o.png)

## Requisições

#### POST - product
- Esta requisição serve para inserção de novos produtos.
- informe no body todos atributos do produto que irá cadastrar(Os campos Id, code,barCode e series serão gerados automaticamentes na inserção do produto):

![alt text](https://github.com/Vitorsandrade/desafio-south-impulsionar/blob/main/images/Post%20-%20product.png)

#### GET ALL - products
- Esta requisição serve para listar dos os produtos que estão no seu banco.
- Foi feito uma listagem eficiente, logo, pode ser passada a página na qual quer vizualizar do seu banco(Cada página possui 10 produtos).

#### GET - product by id
- Esta requisição serve para a busca do produto pelo ID, passando: localhost:8080/api/products/(**ID desejado**)

#### DELETE - product
- Esta requisição serve para deletar produto pelo ID, passando: localhost:8080/api/products/(**ID desejado**)

#### PUT - product
- Esta requisição serve para atualizar dados do produto, passando o ID: localhost:8080/api/products/(**ID desejado**) e no body passando os dados atualizados.

#### IMPORT - products
- Esta requisição serve para importar arquivos .csv  que contém produtos passados no padrão:
  - código,codigo de barras,série,nome,descrição,categoria,valor bruto,impostos (%),data de fabricação,data de validade,cor,material
- Pode ser usado o arquivo mostruario_fabrica.csv que está dentro da pasta do projeto para importar tais produtos.
- Também pode ser passado qualquer outro arquivo .csv com o mesmo padrão.
- Iforme o arquivo desejado na aba body e selecionando a opção form-data passando a chave **file** e o valor seria seu determinado arquivo:

![alt text](https://github.com/Vitorsandrade/desafio-south-impulsionar/blob/main/images/Import%20-%20products.png)

## Testes com Postman(Aplicação Product Producer API)

## Requisições

#### BONUS POST
- Esta requisição envia uma mensagem através do rabbitmq, o consumidor irá fazer a leitura da mensagem e inserir um novo produto com os atrbutos que foram passados
no corpo da requisição.

#### BONUS GET ALL
- 
#### BONUS GET BY ID

#### BONUS DELETE
- Esta requisição envia uma mensagem através do rabbitmq, o consumidor irá fazer a leitura da mensagem e deletar um produto de id igual ao que foi passado no parametro da requisição.
#### BONUS PUT
- Esta requisição envia uma mensagem através do rabbitmq, o consumidor irá fazer a leitura da mensagem e atualizar de id igual ao que foi passado no parametro da requisição.
