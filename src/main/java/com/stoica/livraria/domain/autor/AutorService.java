package com.stoica.livraria.domain.autor;

import java.util.List;

import jakarta.transaction.Transactional;

public interface AutorService {

	List<Autor> listarAutores();

	Autor encontrarAutorPeloID(Long id);

	List<Autor> encontrarAutorPeloNome(String nome);

	Autor salvarAutor(Autor autor);
	

}