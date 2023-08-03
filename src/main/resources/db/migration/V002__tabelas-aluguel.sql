  CREATE TABLE IF NOT EXISTS aluguel (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  cliente_id BIGINT,
  data DATETIME,
  data_prevista_devolucao DATETIME,
  data_devolucao DATETIME,
  status VARCHAR(255) default 'ALUGADO',
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS aluguel_livro (
  id BIGINT AUTO_INCREMENT,
  aluguel_id BIGINT,
  livro_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (aluguel_id) REFERENCES aluguel(id),
  FOREIGN KEY (livro_id) REFERENCES livro(id)
);