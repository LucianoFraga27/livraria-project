package com.stoica.livraria.domain.livro.persistence;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.autor.Autor;
import com.stoica.livraria.domain.autor.AutorService;
import com.stoica.livraria.domain.exception.IsbnExistenteException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoIDException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoISBNException;
import com.stoica.livraria.domain.livro.LivroService;
import com.stoica.livraria.domain.livro.Livro;

import jakarta.transaction.Transactional;

@Service
class CadastroLivroServiceBean implements LivroService{

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorService autorService;

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


	public Livro criarLivro(Livro livro) {
		
			livroRepository.findByISBN(livro.getISBN()).ifPresent(l -> {
				throw new IsbnExistenteException(l.getISBN());
			});
			
			List<Autor> autores =  autorService.SeNaoEncontrarAutorCria(livro.getAutor());
			livro.setAutor(autores);
		return salvarLivro(livro);
	}
	
	@Transactional
	private Livro salvarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	@Transactional
	public Livro editarLivro(Long id, Livro livro) {
		Livro livroAtual = encontrarLivroPeloID(id);
		if(livro.getISBN()==null) {
			livro.setISBN(livroAtual.getISBN());
		} else {
			livroRepository.findByISBN(livro.getISBN()).ifPresent(l -> {
				throw new IsbnExistenteException(l.getISBN());
			});
		}
		BeanUtils.copyProperties(livro, livroAtual, "id");
		return salvarLivro(livroAtual);
	}
	
	
	@Transactional
	void removerLivro(Long id) {

	}
	
	public Livro alterarStatus(Long id) {
		Livro livro = encontrarLivroPeloID(id);
		livro.setStatus(livro.getStatus().equals("DISPONIVEL") ? "INDISPONIVEL" : "DISPONIVEL");
		return salvarLivro(livro);
	}
	
	
}
