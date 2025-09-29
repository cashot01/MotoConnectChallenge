CREATE TABLE tb_rfid (
     id SERIAL PRIMARY KEY,
     nome_area VARCHAR(100) NOT NULL,
     latitude NUMERIC(9,6) NOT NULL,
     longitude NUMERIC(9,6) NOT NULL
);