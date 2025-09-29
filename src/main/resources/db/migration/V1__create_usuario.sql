CREATE TABLE tb_usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    CONSTRAINT uk_usuario_email UNIQUE (email) );