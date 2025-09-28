CREATE TABLE tb_historico_moto (
                                   id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                   parte VARCHAR2(50) NOT NULL,
                                   descricao VARCHAR2(500) NOT NULL,
                                   moto_id NUMBER NOT NULL,
                                   usuario_id NUMBER NOT NULL,
                                   data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   CONSTRAINT fk_historico_moto FOREIGN KEY (moto_id) REFERENCES tb_moto(id) ON DELETE CASCADE,
                                   CONSTRAINT fk_historico_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id) ON DELETE CASCADE
);