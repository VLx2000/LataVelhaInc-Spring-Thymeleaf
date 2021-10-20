# LataVelhaInc. (Site de compra e venda de veiculos usando Spring/Thymeleaf)


### Dependências ###
- MySQL (https://www.mysql.com/downloads/)
- Java 11 (https://www.oracle.com/java/technologies/downloads/#java11)

Ubuntu
```
sudo apt install mysql-server openjdk-11-jdk
```
Fedora
```
sudo dnf install mysql java-11-openjdk
```

### Antes de executar ###
Acesse o arquivo application.properties localizado em:
```
LataVelhaInc/src/main/resources/application.properties
```
e nas linhas 3 e 4, coloque seu usuário e senha do MySQL, respectivamente.

Para correto funcionamento, o site foi previamente povoado com alguns exemplos de clientes e lojas, sendo eles:
```
- cliente1
  - Senha: 123
  - Login: cliente1@gmail.com
- cliente2        
  - Senha: 123        
  - Login: cliente2@gmail.com
- loja1           
  - Senha: 123           
  - Login: loja1@gmail.com
- loja2           
  - Senha: 123           
  - Login: loja2@gmail.com
- loja3           
  - Senha: 123           
  - Login: loja3@gmail.com
- admin           
  - Senha: admin           
  - Login: admin
```
além também de alguns carros e propostas.
Para adicioná-los, dentro da raiz do projeto, acesse o mysql com o seguinte comando:
```
mysql -uroot -p
```
E então execute:
```
source LataVelhaInc/db/MySQL/create.sql;quit;
```

### Para executar ###
1. Clone ou baixe o repositório ```git clone https://github.com/VLx2000/LataVelhaInc-Spring-Thymeleaf.git```
2. Acesse a pasta **LataVelhaInc** ```cd LataVelhaInc/```
3. Execute ```./mvnw spring-boot:run```
4. Em um navegador acesse http://localhost:8080/
5. E, por fim, compre seu Corsa turbinado ou Uno com escada!

#### Envio de email ####


### Integrantes ###

- Lucas Vinícius Domingues 769699
- Rafael Yoshio Yamawaki Murata 769681
- Victor Luís Aguilar Antunes 769734

Arquivo com a separação dos requisitos:
[Checklist](checklist.md)

Documento de requisitos:
[Requisitos](Requisitos-A2.pdf)

Configuração Spring:
[Initializr](spring-initializr.png)
