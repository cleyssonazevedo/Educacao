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
    complemento VARCHAR(255)
);

CREATE TABLE telefone (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pessoa INT NOT NULL UNIQUE,
    numero VARCHAR(25) NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT fk_endereco_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id) ON DELETE CASCADE;
ALTER TABLE telefone ADD CONSTRAINT fk_telefone_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id) ON DELETE CASCADE;