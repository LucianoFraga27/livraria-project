package com.stoica.livraria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.exception.AutorNaoEncontradoException;
import com.stoica.livraria.domain.exception.IsbnExistenteException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoIDException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoISBNException;
import com.stoica.livraria.domain.model.Autor;
import com.stoica.livraria.domain.model.Livro;
import com.stoica.livraria.domain.repository.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class CadastroLivroService {

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	CadastroAutorService autorService;

	public List<Livro> listarLivrosTodos() {
		return livroRepository.findAll();
	}

	public Livro encontrarLivroPeloID(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoIDException(id));
	}

	public Livro encontrarLivroPeloISBN(String isbn) {
		return livroRepository.findByISBN(isbn).orElseThrow(() -> new LivroNaoEncontradoISBNException(isbn));
	}

	public List<Livro> encontrarLivroPeloTitulo(String titulo) {
		return livroRepository.findByTituloContaining(titulo);
	}

	@Transactional
	public Livro salvarLivro(Livro livro) {

		
			livroRepository.findByISBN(livro.getISBN()).ifPresent(l -> {
				throw new IsbnExistenteException(l.getISBN());
			});
			
			//List<Autor> autores =  autorService.encontrarAutores(livro.getAutor());
			//livro.setAutor(autores);
		return livroRepository.save(livro);
	}
	
	@Transactional
	public Livro editarLivro(Long id) {
		return null;
	}
	
	

	@Transactional
	void removerLivro(Long id) {

	}

}
