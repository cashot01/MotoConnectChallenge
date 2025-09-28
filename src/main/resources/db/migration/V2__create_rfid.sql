CREATE TABLE tb_rfid (
                         id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         nome_area VARCHAR2(100) NOT NULL,
                         latitude NUMBER(9,6) NOT NULL,
                         longitude NUMBER(9,6) NOT NULL
);