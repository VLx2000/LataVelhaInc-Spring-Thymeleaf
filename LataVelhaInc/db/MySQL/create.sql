drop database if exists Aluguel_Veiculos;

create database Aluguel_Veiculos;
use Aluguel_Veiculos;

create table Cliente(id bigint not null auto_increment,email varchar(30) not null, senha varchar(50) not null, cpf varchar(20) not null, nome varchar (50) not null,
telefone varchar(20) not null, sexo varchar(10) not null, data_nascimento varchar(10) not null, role varchar(10) not null, primary key(id));

create table Loja(id bigint not null auto_increment, email varchar(30) not null, senha varchar(50) not null, cnpj varchar(18), nome varchar (50) not null, 
descricao varchar(120),primary key(id));

create table Veiculo(id bigint not null auto_increment, placa varchar(20) not null, modelo varchar(20) not null,
chassi varchar(17) not null, ano integer not null, quilometragem integer not null, descricao varchar(120) not null, 
preco float not null,id_loja bigint not null, primary key(id),foreign key(id_loja) references Loja(id));

create table Proposta(id bigint not null auto_increment,id_cliente bigint not null, id_loja bigint not null, id_veiculo bigint not null,
preco float not null, data_p varchar(10) not null, estado varchar(11) not null, parcelamento varchar(11) not null, primary key(id), 
foreign key(id_cliente) references Cliente(id),foreign key(id_loja) references Loja(id),
foreign key(id_veiculo) references Veiculo(id));