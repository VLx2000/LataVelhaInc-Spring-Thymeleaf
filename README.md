# LataVelhaInc. (Site de compra e venda de veiculos usando Spring/Thymeleaf)

## Integrantes ##

- Lucas Vinícius Domingues 769699
- Rafael Yoshio Yamawaki Murata 769681
- Victor Luís Aguilar Antunes 769734

Arquivo com a separação dos requisitos:
[Checklist](doc/checklist.md)

Documento de requisitos:
[Requisitos](doc/Requisitos-A2.pdf)

Configuração Spring:
[Initializr](doc/spring-initializr.png)

## Dependências ###
- MySQL (https://www.mysql.com/downloads/)
- Java 11 (https://www.oracle.com/java/technologies/downloads/#java11)

### Ubuntu ###
```
sudo apt install mysql-server openjdk-11-jdk
```

## Antes de executar ##
Acesse o arquivo application.properties localizado em:
```
LataVelhaInc/src/main/resources/application.properties
```
e nas linhas 3 e 4, coloque seu usuário e senha do MySQL, respectivamente.

Para correto funcionamento, o site foi previamente povoado com alguns exemplos de clientes e lojas, sendo eles:

Nome | Login | Senha | Tipo
|:---|---|:---:|---:|
Jorge | jorjao@gmail.com | 123 | Cliente
Airton Cena | irto@gmail.com | 123 | Cliente
Michael Wazowski | mw@gmail.com | 123 | Cliente
Carros e Ventiladores SA | carros@gmail.com | 123 | Loja
Ferro velho do Maicao | ferro@gmail.com | 123 | Loja
Tesla saocarlense | teslabr@gmail.com | 123 | Loja
Admin | admin | admin | Administrador

além também de alguns carros e propostas.
Para adicioná-los, dentro da raiz do projeto, acesse o mysql com o seguinte comando:
```
mysql -uroot -p
```
E então execute:
```
source LataVelhaInc/db/MySQL/create.sql;quit;
```
Configurando envio de email:

Acesse o arquivo application.properties localizado em
```
LataVelhaInc/src/main/resources/application.properties
```
e adicione seu usuário e senha do https://mailtrap.io/ nas linhas 22 e 23, respectivamente.
Então, se logue como loja e envie uma mensagem para alguma proposta em aberto.

## Para executar ##
1. Clone ou baixe o repositório
```
git clone https://github.com/VLx2000/LataVelhaInc-Spring-Thymeleaf.git
```
2. Acesse a pasta **LataVelhaInc** 
```
cd LataVelhaInc/
```
3. Execute
```
./mvnw spring-boot:run
```
4. Em um navegador acesse http://localhost:8080/
5. E, por fim, compre seu Corsa turbinado ou Uno com escada!