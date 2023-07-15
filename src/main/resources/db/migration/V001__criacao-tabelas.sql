-- Tabela Autor
CREATE TABLE IF NOT EXISTS autor (
	id bigint primary key auto_increment,
	nome varchar(255) not null
);


-- Tabela Cliente
CREATE TABLE IF NOT EXISTS cliente (
	id bigint primary key auto_increment,
	nome varchar(255) not null,
    cpf varchar(11) not null,
    email varchar(255) not null
);


-- Tabela Livro
CREATE TABLE livro (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  isbn VARCHAR(255),
  titulo VARCHAR(255) NOT NULL,
  editora VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  data_publicacao DATE,
  status VARCHAR(255),
  autor_id BIGINT,
  FOREIGN KEY (autor_id) REFERENCES autor(id)
);


-- Tabela Relacionamento Livro_Autor
CREATE TABLE livro_autor (
  autor_id BIGINT,
  livro_id BIGINT,
  PRIMARY KEY (autor_id, livro_id),
  FOREIGN KEY (autor_id) REFERENCES autor(id),
  FOREIGN KEY (livro_id) REFERENCES livro(id)
);
