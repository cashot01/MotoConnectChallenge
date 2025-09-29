CREATE TABLE tb_moto (
     id SERIAL PRIMARY KEY,
     modelo VARCHAR(50) NOT NULL,
     placa VARCHAR(7) NOT NULL,
     status VARCHAR(15) NOT NULL,
     rfid_id INT,
     usuario_id BIGINT NOT NULL,

     CONSTRAINT uk_moto_placa UNIQUE (placa),
     CONSTRAINT fk_moto_rfid FOREIGN KEY (rfid_id) REFERENCES tb_rfid(id) ON DELETE SET NULL,
     CONSTRAINT fk_moto_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);