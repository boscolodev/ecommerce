CREATE SCHEMA IF NOT EXISTS ecommerce;

CREATE TABLE tb_endereco (
                             id VARCHAR(255) PRIMARY KEY,
                             cep VARCHAR(255) UNIQUE NOT NULL,
                             logradouro VARCHAR(255),
                             complemento VARCHAR(255),
                             unidade VARCHAR(255),
                             bairro VARCHAR(255),
                             localidade VARCHAR(255),
                             uf VARCHAR(255),
                             estado VARCHAR(255),
                             regiao VARCHAR(255),
                             ibge VARCHAR(255),
                             gia VARCHAR(255),
                             ddd VARCHAR(255),
                             siafi VARCHAR(255)
);