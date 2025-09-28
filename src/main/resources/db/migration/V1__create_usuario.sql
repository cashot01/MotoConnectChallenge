CREATE TABLE tb_usuario (
                            id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                            nome VARCHAR2(100) NOT NULL,
                            email VARCHAR2(100) NOT NULL,
                            senha VARCHAR2(100) NOT NULL,
                            role VARCHAR2(20) DEFAULT 'USER',
                            CONSTRAINT uk_usuario_email UNIQUE (email)
);