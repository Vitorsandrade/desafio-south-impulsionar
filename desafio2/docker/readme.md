# Explicação dos comandos:

version: "3.5" : versao do compose

services: setando os serviços

database: #nome do serviço
image: postgres:14-alpine #setando a imagem
restart: always #definindo estratégia de restart
environment:
POSTGRES_PASSWORD: postgres #setando a senha
ports:
- "5434:5432" #expondo a porta 5434

* POSTGRES_USER é OPCIONAL. Se nao setar POSTGRES_USER será usado o padrão "postgres"
* POSTGRES_DB é OPCIONAL. Se nao setar POSTGRES_DB será usado o nome do POSTGRES_USER
* FONTE: https://hub.docker.com/_/postgres
* Versão alpine é a versão mais leve, por isso foi usada no exemplo

#Referências:
* https://hub.docker.com/_/postgres
* https://alpinelinux.org/
* https://medium.com/swlh/alpine-slim-stretch-buster-jessie-bullseye-bookworm-what-are-the-differences-in-docker-62171ed4531d