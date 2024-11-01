CREATE TABLE tb_usuario (
                            id VARCHAR(255) PRIMARY KEY,
                            nome VARCHAR(255) UNIQUE NOT NULL,
                            sobrenome VARCHAR(255) UNIQUE NOT NULL,
                            email VARCHAR(255) UNIQUE NOT NULL,
                            senha VARCHAR(255) NOT NULL,
                            documento VARCHAR(255) UNIQUE NOT NULL,
                            rg VARCHAR(255) UNIQUE NOT NULL,
                            telefone VARCHAR(255),
                            celular VARCHAR(255),
                            sexo VARCHAR(255)
);