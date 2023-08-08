package com.stoica.livraria.domain.autor;

import java.util.List;


public interface AutorService {
	
	List<Autor> listarAutores();

	Autor encontrarAutorPeloID(Long id);

	List<Autor> encontrarAutorPeloNome(String nome);

	Autor salvarAutor(Autor autor);
	
	List<Autor> SeNaoEncontrarAutorCria(List<Autor> autores);
	
}