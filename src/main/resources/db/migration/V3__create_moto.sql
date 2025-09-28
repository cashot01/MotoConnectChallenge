CREATE TABLE tb_moto (
                         id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         modelo VARCHAR2(10) NOT NULL,
                         placa VARCHAR2(7) NOT NULL,
                         data_cadastro DATE NOT NULL,
                         status VARCHAR2(15) NOT NULL,
                         rfid_id NUMBER,
                         usuario_id NUMBER NOT NULL,
                         CONSTRAINT uk_moto_placa UNIQUE (placa),
                         CONSTRAINT fk_moto_rfid FOREIGN KEY (rfid_id) REFERENCES tb_rfid(id) ON DELETE SET NULL,
                         CONSTRAINT fk_moto_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id) ON DELETE CASCADE
);