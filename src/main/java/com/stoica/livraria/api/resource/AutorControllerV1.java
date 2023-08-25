package com.stoica.livraria.api.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.domain.autor.Autor;
import com.stoica.livraria.domain.autor.AutorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/autores")
@AllArgsConstructor
public class AutorControllerV1 {

	AutorService cadastroAutor;
	
	
	@GetMapping("")
	public List<Autor> listarAutores(){
		return cadastroAutor.listarAutores();
	}
	
	@GetMapping("/id/{id}")
	public Autor encontrarAutorPeloID(@PathVariable(value="id") Long id){
		return cadastroAutor.encontrarAutorPeloID(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Autor> encontrarAutorPeloNome(@PathVariable(value="nome") String nome){
		return cadastroAutor.encontrarAutorPeloNome(nome);
	}
	
	@PostMapping("")
	public Autor salvarAutor(@RequestBody Autor autor) {
		return cadastroAutor.salvarAutor(autor);
	}
	
	
}
