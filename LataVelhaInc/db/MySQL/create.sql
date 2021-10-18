drop database if exists Aluguel_Veiculos;

create database Aluguel_Veiculos;
use Aluguel_Veiculos;

create table Cliente(id bigint not null auto_increment,email varchar(30) not null, senha varchar(50) not null, cpf varchar(20) not null, nome varchar (50) not null,
telefone varchar(20) not null, sexo varchar(10) not null, nascimento varchar(10) not null, papel varchar(10) not null, primary key(id));

create table Loja(id bigint not null auto_increment, email varchar(30) not null, senha varchar(50) not null, cnpj varchar(20), nome varchar (50) not null, 
descricao varchar(120),primary key(id));

create table Veiculo(id bigint not null auto_increment, placa varchar(20) not null, modelo varchar(20) not null,
chassi varchar(17) not null, ano integer not null, quilometragem integer not null, descricao varchar(120) not null, 
valor float not null,id_loja bigint not null, primary key(id),foreign key(id_loja) references Loja(id));

create table Proposta(id bigint not null auto_increment,id_cliente bigint not null, id_loja bigint not null, id_veiculo bigint not null,
valor float not null, data_p varchar(10) not null, estado varchar(11) not null, parcelamento varchar(11) not null, primary key(id), 
foreign key(id_cliente) references Cliente(id),foreign key(id_loja) references Loja(id),
foreign key(id_veiculo) references Veiculo(id));

insert into Cliente(email,senha,cpf,nome,telefone,sexo,nascimento,papel) values ('cliente1@gmail.com','cliente1','111.111.111-11',
'cliente1','1111111111','M','2000-01-01','USER');
insert into Cliente(email,senha,cpf,nome,telefone,sexo,nascimento,papel) values ('cliente2@gmail.com','cliente2','222.222.222-11',
'cliente2','3543543455','F','1989-01-01','USER');

insert into Cliente(email,senha,cpf,nome,telefone,sexo,nascimento,papel) values ('admin','admin','cpf_admin',
'admin01','12345678','M','1997-08-20','ADMIN');

insert into Loja(email,senha,cnpj,nome,descricao) values ('loja1@gmail.com','loja1','111.111.111/0001-11','loja1','primeira loja');
insert into Loja(email,senha,cnpj,nome,descricao) values ('loja2@gmail.com','loja2','222.222.222/0001-11','loja2','segunda loja');
insert into Loja(email,senha,cnpj,nome,descricao) values ('loja3@gmail.com','loja3','333.333.333/0001-11','loja3','terceira loja');

insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('AAA0-7473', 'Corsa','1A1A1111111111111',2005,120000, 'Corsa 2005 turbinado',20000,1);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('WTBW-7473', 'Fusca','5B4B563563456346',1997,160000, 'Fusca 97 rebaixado ',6000,2);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('RBWT-7473', 'Uno','3A5A4564356346',2007,100000, 'Uno Mile 2007',12000,1);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('RWTBRW-7473', 'Palio','7C4C458548764',2005,110000, 'Palio 2005 em bom estado',8000,2);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('WREB-7473', 'Monza','2R6D5636465456',2006,100000, 'Monza',8000,1);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('RTJN-7473', 'Kombi','5D5E3576765473',2003,115000, 'Kombi Branca em bom estado',25000,2);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('NQEA-7473', 'Corolla','134513253656456',2013,95000, 'Corolla 2013',15000,3);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('KYTRT-7473', 'Ka','0D60R8784784563',2015,90000, 'Ford Ka seminovo',23000,3);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('HEBBT-7473', 'Focus','2P45C4769897897',2012,105000, 'Focus 2012 em bom estado',16000,3);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('ERBVE-7473', 'F50','2E5K5687686786',2019,60000, 'Ferrari F50 vermelha',450000,3);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('EQB-7473', 'R8','25765878976536546',2020,30000, 'Audi R8',250000,3);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('BEBE-7473', 'RX-7','175785635744747',2017,80000, 'RX-7 seminovo',200000,1);
insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('EBRH-7473', 'Camaro','54562575734747',2016,95000, 'Caro seminovo',100000,1);

insert into Proposta(id_cliente,id_loja,id_veiculo, valor,data_p, estado, parcelamento) values (1,1,1,17000,'2021-09-23', 'ABERTO',12);
insert into Proposta(id_cliente,id_loja,id_veiculo, valor,data_p, estado, parcelamento) values (1,1,3,10500,'2021-09-23', 'ACEITO',14);
insert into Proposta(id_cliente,id_loja,id_veiculo, valor,data_p, estado, parcelamento) values (2,2,2,4500,'2021-09-23', 'ABERTO',30);
insert into Proposta(id_cliente,id_loja,id_veiculo, valor,data_p, estado, parcelamento) values (2,1,3,10000,'2021-09-23', 'RECUSADO',1);



