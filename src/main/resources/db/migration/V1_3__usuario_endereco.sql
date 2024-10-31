CREATE TABLE tb_usuario_endereco (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     usuario_id VARCHAR(255),
                                     endereco_id VARCHAR(255),
                                     numero VARCHAR(255),
                                     complemento VARCHAR(255),
                                     CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id),
                                     CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES tb_endereco(id)
);