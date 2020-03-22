DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome     varchar(200),
    endereco    varchar(200),
    rendimento_mensal decimal,
    possui_emprego boolean DEFAULT TRUE,
    valor_tot_patrimonio decimal,
    valor_tot_dividas decimal,
    valor_emprestimo_solicitado decimal,
    valor_emprestimo_final decimal,
    numero_parcelas int,
    UNIQUE (nome)
);

INSERT INTO cliente(id, nome, endereco, rendimento_mensal, possui_emprego, valor_tot_patrimonio, valor_tot_dividas,
valor_emprestimo_solicitado, valor_emprestimo_final, numero_parcelas)
VALUES (1, 'José Raimundo Nunes', 'Rua 10, Apto. 22, Residencial Ponta Negra', 30.000, null , 200.000, 400.000, 100.000,null, null );

