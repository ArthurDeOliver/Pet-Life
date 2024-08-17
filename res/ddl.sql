CREATE DATABASE IF NOT EXISTS petlife;

USE petlife;

CREATE TABLE IF NOT EXISTS animais(
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
nome VARCHAR(45),
idade INT,
tipo VARCHAR(45),
raca Varchar(45),
racao INT,
status VARCHAR(45),
vacina VARCHAR(45),
foto VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS adocao (
id_pet INT,
nome_pet VARCHAR(45),
tipo_pet VARCHAR(45),
nome_tutor VARCHAR(255),
cpf_tutor VARCHAR(45),
endereco_tutor VARCHAR(255),
telefone_tutor VARCHAR(45),
FOREIGN KEY (id_pet) REFERENCES animais(id),
PRIMARY KEY (id_pet, cpf_tutor)
);

CREATE TABLE IF NOT EXISTS medicamentos (
Nome_medicamento VARCHAR(45),
Quantidade_Medicamento INT,	
Valor_Medicamento DECIMAL (10,2),
Primary key Nome_medicamento 	
);

CREATE TABLE IF NOT EXISTS racoes (
Marca_Racao VARCHAR(45),
Quantidade_Racao INT,
Valor_Racao DECIMAL (8,2),
Primary key Marca_Racao		
);

CREATE TABLE IF NOT EXISTS vacinas(
Nome_Vacina VARCHAR(45),
Quantidade_Vacina INT,
Valor_Vacina DECIMAL (10,2),	
Primary key Nome_Vacina,
);