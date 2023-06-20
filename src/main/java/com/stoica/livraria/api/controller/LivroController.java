package com.stoica.livraria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.domain.model.Livro;
import com.stoica.livraria.domain.service.CadastroLivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	CadastroLivroService livroService;
	
	@GetMapping("/todos")
	public List<Livro> listarLivrosTodos(){
		return livroService.listarLivrosTodos();
	}
	
	@GetMapping("/id/{id}")
	public Livro encontrarLivroPeloID(@PathVariable(value = "id") Long id) {
		return livroService.encontrarLivroPeloID(id);
	}
	
	@GetMapping("/titulo/{titulo}")
	public List<Livro> encontrarLivroPeloTitulo(@PathVariable(value = "titulo") String titulo) {
		return livroService.encontrarLivroPeloTitulo(titulo);
	}
	
	
	
	@PutMapping("/editar/{id}")
	public Livro editarLivro (@RequestBody @Valid Livro livro, @PathVariable(value="id") Long id) {
		return null;
	}
	
	
	
}
