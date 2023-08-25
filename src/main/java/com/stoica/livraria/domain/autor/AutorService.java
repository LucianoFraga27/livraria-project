package com.stoica.livraria.domain.autor;

import java.util.List;
import java.util.Optional;


public interface AutorService {
	
	List<Autor> listarAutores();

	Autor encontrarAutorPeloID(Long id);
	
	Optional<Autor> encontrarAutorPeloId_v2(Long id);
	
	List<Autor> encontrarAutorPeloNome(String nome);

	Autor salvarAutor(Autor autor);
	
	List<Autor> SeNaoEncontrarAutorCria(List<Autor> autores);
	
}