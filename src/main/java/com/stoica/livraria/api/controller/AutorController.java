package com.stoica.livraria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.domain.model.Autor;
import com.stoica.livraria.domain.service.CadastroAutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	CadastroAutorService autorService;

	@GetMapping("/todos")
	public List<Autor> listarAutores(){
		return autorService.listarAutores();
	}
	
	@GetMapping("/id/{id}")
	public Autor encontrarAutorPeloID(@PathVariable(value="id") Long id){
		return autorService.encontrarAutorPeloID(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Autor> encontrarAutorPeloNome(@PathVariable(value="nome") String nome){
		return autorService.encontrarAutorPeloNome(nome);
	}
	
	@PostMapping("/adicionar")
	public Autor salvarAutor(@RequestBody Autor autor) {
		return autorService.salvarAutor(autor);
	}
	
	
}
