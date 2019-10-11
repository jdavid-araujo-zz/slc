# slc

## About

O sistema carrega o arquivo SLC0001-modelo.xml de um GitGub, salva em uma base de dados Postgresql e pé disponibilizada por um endpoint: /slc

## Solução

Ao iniciar a aplicação, é implementado a Interface CommandLineRunner para carregar e salvar na base de dados o arquivo SLC0001-modelo.xml logo após a aplicação é iniciada.
O serviço FileService é utilizado para a decodificação do documento XML em um JOPO e utilizado as tecnologia JPA com Spring Data, os objetos
são persistidos na base de dados. O EndPont /slc é utilizado para retornar os dados do arquivo persistidos na base de dados.

## How to Run

A aplicação utiliza Tomcat 8 embedded e pode utilizar H2 database embedded, desde que seja modificado o arquivo: application.properties do projeto. O Tomcat ou JBoss instados não são necessários.

* Clone o repository
* A aplicação utiliza JDK 1.8 and Maven 3.x
* Para executar utilize o comando abaixo ou em uma IDE:

 ```cd slc and mvn spring-boot:run```
 
## Heroku

Foi realizado o deploy da aplicação no heroku e esta pode ser acessada pela URL: https://slc-service.herokuapp.com, sendo o endpoint: https://slc-service.herokuapp.com/slc 
utilizada para acessar os dados.
