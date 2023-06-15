package com.stoica.livraria.domain.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.exception.IsbnExistenteException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoException;
import com.stoica.livraria.domain.model.Livro;
import com.stoica.livraria.domain.repository.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class CadastroLivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> listarLivros(){
		return livroRepository.findAll();
	}
	
	
	public Livro encontrarLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(
				() -> new LivroNaoEncontradoException(id));
	}
	
	@Transactional
	void adicionarLivro(Livro livro) {
		livroRepository.findByISBN(livro.getISBN()).ifPresent(
				l -> {
					throw new IsbnExistenteException(l.getISBN());
				});
		livroRepository.save(livro);
	}
	
	@Transactional
	void removerLivro(Long id) {
		
	}
	
	
	
}
