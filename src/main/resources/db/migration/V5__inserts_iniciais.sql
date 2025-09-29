INSERT INTO tb_usuario(nome,email,senha,role)
VALUES ('Admin','admin@motoconnect.com','admin123','ADMIN'), ('Usuario1','user1@motoconnect.com','user123','USER');


INSERT INTO tb_rfid(nome_area,latitude,longitude)
VALUES ('Area 1', -23.564, -46.654), ('Area 2', -23.565, -46.655);


INSERT INTO tb_moto(modelo,placa,status,usuario_id)
VALUES ('POP','ABC1234','NAO_INICIADO',1), ('SPORT','XYZ5678','MANUTENCAO',2);


INSERT INTO tb_historico_moto(parte,descricao,moto_id,usuario_id)
VALUES ('Motor','Revisão inicial',1,1), ('Freio','Troca de pastilhas',2,2);