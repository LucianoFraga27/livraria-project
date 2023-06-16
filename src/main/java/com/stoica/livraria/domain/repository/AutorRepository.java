package com.stoica.livraria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	List<Autor> findByNome(String nome);
	
}
