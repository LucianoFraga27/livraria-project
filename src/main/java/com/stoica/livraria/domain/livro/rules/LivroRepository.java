package com.stoica.livraria.domain.livro.rules;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.livro.Livro;

interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByISBN(String ISBN);
	List<Livro> findByTituloContaining(String titulo);
	
}
