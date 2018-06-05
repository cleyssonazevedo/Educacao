DROP DATABASE IF EXISTS educacao;
CREATE DATABASE educacao;

USE educacao;

CREATE TABLE pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    idade TINYINT NOT NULL,
    sexo ENUM('M', 'F', 'ND')
);

CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT NOT NULL UNIQUE,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(10),
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado CHAR(2) NOT NULL,
    complemento VARCHAR(255),
    cep CHAR(9)
);

CREATE TABLE telefone (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pessoa INT NOT NULL UNIQUE,
    numero VARCHAR(25) NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT fk_endereco_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id) ON DELETE CASCADE;
ALTER TABLE telefone ADD CONSTRAINT fk_telefone_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id) ON DELETE CASCADE;

DELIMITER $$
CREATE PROCEDURE sp_salvar (
    nome VARCHAR(255),
    idade TINYINT,
    sexo VARCHAR(2),

    logradouro VARCHAR(255),
    numero VARCHAR(10),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado CHAR(2),
    complemento VARCHAR(255),
    cep CHAR(9),

    telefone VARCHAR(25)
)
BEGIN
    INSERT INTO pessoa (nome, idade, sexo) VALUES (nome, idade, sexo);
    SET @id_pessoa = last_insert_id();
    INSERT INTO endereco VALUES (0, @id_pessoa, logradouro, numero, bairro, cidade, estado, complemento, cep);
    INSERT INTO telefone VALUES (0, @id_pessoa, telefone);
END $$
DELIMITER ;