package com.stoica.livraria.domain.autor.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.autor.Autor;
import com.stoica.livraria.domain.autor.AutorService;
import com.stoica.livraria.domain.exception.AutorNaoEncontradoException;

import jakarta.transaction.Transactional;

@Service
class CadastroAutorServiceBean implements AutorService {

	@Autowired
	AutorRepository autorRepository;
	
	public List<Autor> listarAutores(){
		return autorRepository.findAll();
	}
	
	public Autor encontrarAutorPeloID(Long id) {
		return autorRepository.findById(id).orElseThrow(
				() -> new AutorNaoEncontradoException(id));
	}
	
	public List<Autor> encontrarAutorPeloNome(String nome) {
		return autorRepository.findByNomeContaining(nome);
	}
	
	@Transactional
	public Autor salvarAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Transactional
	public List<Autor> SeNaoEncontrarAutorCria(List<Autor> autores) {
		
		List<Autor> autoresEncontrados = new ArrayList<>();
		
		for (Autor autor : autores) {
			
			Optional<Autor> autorTeste = autorRepository.findById(autor.getId());
			if(autorTeste.isPresent()) {
				
				autoresEncontrados.add(autorTeste.get());
				
			} else {
				
				Autor novoAutor = new Autor();
				novoAutor.setId(autor.getId());
				novoAutor.setNome(autor.getNome());
				
				autoresEncontrados.add(autorRepository.save(novoAutor));
			}
		}
		
		return autoresEncontrados;
		
	}
	
}
