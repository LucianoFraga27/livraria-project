package com.stoica.livraria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/adicionar")
	public Autor salvarAutor(@RequestBody Autor autor) {
		return autorService.salvarAutor(autor);
	}
	
}
