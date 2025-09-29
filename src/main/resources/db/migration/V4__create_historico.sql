CREATE TABLE tb_historico_moto (
   id SERIAL PRIMARY KEY,
   parte VARCHAR(50) NOT NULL,
   descricao VARCHAR(500) NOT NULL,
   moto_id INT NOT NULL,
   usuario_id BIGINT NOT NULL,

    CONSTRAINT fk_historico_moto FOREIGN KEY (moto_id) REFERENCES tb_moto(id) ON DELETE CASCADE,
    CONSTRAINT fk_historico_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);