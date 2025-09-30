INSERT INTO tb_usuario (nome, email, avatar_url)
VALUES
    ('João Silva', 'joao.silva@email.com', 'https://example.com/avatar1.jpg'),
    ('Maria Santos', 'maria.santos@email.com', 'https://example.com/avatar2.jpg');


INSERT INTO tb_rfid(nome_area, latitude, longitude)
VALUES
    ('Area Centro', -23.550520, -46.633308),
    ('Area Zona Norte', -23.500720, -46.625290);


INSERT INTO tb_moto(modelo, placa, status, rfid_id, usuario_id)
VALUES
    ('Honda POP 110i', 'ABC1D23', 'DISPONIVEL', 1, 1),
    ('Yamaha Factor 150', 'EFG2H45', 'EM_USO', 2, 2);


INSERT INTO tb_historico_moto(parte, descricao, moto_id, usuario_id)
VALUES
    ('Motor', 'Troca de óleo e filtro realizada', 1, 1),
    ('Freios', 'Pastilhas de freio substituídas', 2, 2);