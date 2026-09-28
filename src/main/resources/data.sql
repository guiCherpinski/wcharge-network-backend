INSERT INTO tb_estacao (cidade, endereco, nome, status) VALUES
('Jaraguá do Sul', 'Av. Prefeito Waldemar Grubba 3000', 'Eletroposto WEG Matriz', 'ATIVO'),
('Jaraguá do Sul', 'Rua Bernardo Dornbusch 1100', 'Eletroposto WEG Parque Fabril', 'ATIVO'),
('Joinville', 'Rua Dona Francisca 8300', 'Eletroposto Perini Business Park', 'ATIVO'),
('Florianópolis', 'Rodovia SC-401 4100', 'Eletroposto Tech Park Primavera', 'ATIVO'),
('Blumenau', 'Rua São Paulo 3258', 'Eletroposto Shopping Neumarkt', 'MANUTENCAO'),
('Curitiba', 'Av. Cândido de Abreu 127', 'Eletroposto Centro Cívico', 'ATIVO'),
('São Paulo', 'Av. das Nações Unidas 14261', 'Eletroposto Berrini Hub', 'INATIVO');


INSERT INTO tb_carregador (codigo, potencia_kw, status, tipo_conector, valor_kwh, estacao_id) VALUES
('WCHARGE-DC-150KW-01', 150.00, 'LIVRE', 'CCS2', 2.10, 1),
('WCHARGE-DC-150KW-02', 150.00, 'LIVRE', 'CCS2', 2.10, 2),
('WCHARGE-DC-300KW-01', 300.00, 'LIVRE', 'CCS2', 2.50, 2),
('WCHARGE-DC-50KW-01', 50.00, 'LIVRE', 'CCS2', 1.80, 3),
('WCHARGE-DC-150KW-03', 150.00, 'LIVRE', 'CCS2', 2.20, 4),
('WCHARGE-DC-150KW-04', 150.00, 'LIVRE', 'CCS2', 2.10, 5),
('WCHARGE-DC-300KW-02', 300.00, 'LIVRE', 'CCS2', 2.60, 6),
('WCHARGE-DC-150KW-05', 150.00, 'LIVRE', 'CCS2', 2.15, 7),
('WCHARGE-DC-50KW-02', 50.00, 'LIVRE', 'CCS2', 1.85, 7);
insert into tb_usuario(username,password, role) values
('Celso','$2a$10$32N/ptu3jY0WjFH0qLbcEO2ZcCg4gYCJvMbwmqzf84qNCcDFBLl4q','ADMIN'),
('Jorge','$2a$10$32N/ptu3jY0WjFH0qLbcEO2ZcCg4gYCJvMbwmqzf84qNCcDFBLl4q','USER');