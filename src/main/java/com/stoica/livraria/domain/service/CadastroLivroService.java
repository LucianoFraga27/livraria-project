package com.stoica.livraria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Livro encontrarLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoIDException(id));
	}

	@Transactional
	public Livro salvarLivro(Livro livro, Boolean edicao) {

		if (!edicao) {
			livroRepository.findByISBN(livro.getISBN()).ifPresent(l -> {
				throw new IsbnExistenteException(l.getISBN());
			});
		} else if (edicao) {
			Livro livroExistente = livroRepository.findByISBN(livro.getISBN()).orElseThrow(()-> new LivroNaoEncontradoISBNException(livro.getISBN()));
			if(!livroExistente.getISBN().equals(livro.getISBN())) {
				livroRepository.findByISBN(livro.getISBN()).ifPresent(
						c -> {  throw new IsbnExistenteException(livro.getISBN()); });
			}
		}
		
		autorService.SeNaoEncontrarAutorCria(livro.getAutor());
		
		return livroRepository.save(livro);
	}

	@Transactional
	void removerLivro(Long id) {
		
	}
	
	
}
