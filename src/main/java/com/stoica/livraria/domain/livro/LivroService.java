package com.stoica.livraria.domain.livro;

import java.util.List;


public interface LivroService {

	List<Livro> listarLivrosTodos();

	Livro encontrarLivroPeloID(Long id);

	Livro encontrarLivroPeloISBN(String isbn);

	List<Livro> encontrarLivroPeloTitulo(String titulo);

	Livro salvarLivro(Livro livro);

	Livro editarLivro(Long id);

}