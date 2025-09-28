INSERT INTO tb_usuario(nome,email,senha,role) VALUES ('Admin','admin@motoconnect.com','admin123','ADMIN');
INSERT INTO tb_usuario(nome,email,senha,role) VALUES ('Usuario1','user1@motoconnect.com','user123','USER');

INSERT INTO tb_rfid(nome_area,latitude,longitude) VALUES ('Area 1', -23.564, -46.654);
INSERT INTO tb_rfid(nome_area,latitude,longitude) VALUES ('Area 2', -23.565, -46.655);

INSERT INTO tb_moto(modelo,placa,data_cadastro,status,usuario_id) VALUES ('POP','ABC1234',SYSDATE,'NAO_INICIADO',1);
INSERT INTO tb_moto(modelo,placa,data_cadastro,status,usuario_id) VALUES ('SPORT','XYZ5678',SYSDATE,'MANUTENCAO',2);

INSERT INTO tb_historico_moto(parte,descricao,moto_id,usuario_id) VALUES ('Motor','Revisão inicial',1,1);
INSERT INTO tb_historico_moto(parte,descricao,moto_id,usuario_id) VALUES ('Freio','Troca de pastilhas',2,2);
