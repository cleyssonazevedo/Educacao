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
    cep CHAR(9) NOT NULL
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


DROP PROCEDURE IF EXISTS sp_atualizar;
DELIMITER $$
CREATE PROCEDURE sp_atualizar (
	id INT,
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
    UPDATE pessoa p SET 
		p.nome = nome,
        p.idade = idade,
        p.sexo = sexo 
	WHERE p.id = id;
    
    UPDATE endereco e SET 
		e.logradouro = logradouro,
        e.numero = numero,
        e.bairro = bairro,
        e.cidade = cidade,
        e.estado = estado,
        e.complemento = complemento,
        e.cep = cep
	WHERE e.id_pessoa = id;
    
    UPDATE telefone t SET 
		t.numero = telefone
	WHERE t.id_pessoa = id;
END $$
DELIMITER ;


CREATE VIEW vw_pessoa AS
SELECT
	p.id,
    p.nome,
    p.idade,
    p.sexo,
    
    e.id as id_endereco,
    e.id_pessoa as id_pessoa_endereco,
    e.logradouro,
    e.numero,
    e.bairro,
    e.cidade,
    e.estado,
    e.complemento,
    e.cep,
    
    t.id as id_telefone,
    t.id_pessoa as id_pessoa_telefone,
    t.numero as telefone
    
FROM pessoa p
INNER JOIN endereco e
	ON p.id = e.id_pessoa
INNER JOIN telefone t
	ON p.id = t.id_pessoa;
