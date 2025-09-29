CREATE TABLE tb_moto (
    id SERIAL PRIMARY KEY,
    modelo VARCHAR(10) NOT NULL,
    placa VARCHAR(7) NOT NULL,
    status VARCHAR(15) NOT NULL,
    rfid_id INT,
    usuario_id INT NOT NULL,
    CONSTRAINT uk_moto_placa UNIQUE (placa),
    CONSTRAINT fk_moto_rfid FOREIGN KEY (rfid_id) REFERENCES tb_rfid(id) ON DELETE SET NULL,
    CONSTRAINT fk_moto_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id) ON DELETE CASCADE );