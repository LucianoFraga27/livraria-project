package com.stoica.livraria.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByISBN(String ISBN);
	List<Livro> findByTituloContaining(String titulo);
	
}
