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

CREATE TABLE MEDICAMENTOS (
Nome_medicamento VARCHAR(45),
Quantidade INT,	
Valor DECIMAL (10,2),
Primary key Nome_medicamento 	
);

CREATE TABLE Ração(
Marca_Racao VARCHAT(45),
Quantidade_Racao INT,
Valor_Racao DECIMAL (8,2),
Primary key Marca_Racao		
);

CREATE TABLE Vacina(
Nome_Vacina VARCHAR(45),
Quantidade_Vacina INT,
Valor_Vacina DECIMAL (10,2),	
Primary key Nome_Vacina,
);