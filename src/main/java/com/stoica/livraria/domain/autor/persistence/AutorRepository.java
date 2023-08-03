package com.stoica.livraria.domain.autor.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.autor.Autor;

interface AutorRepository extends JpaRepository<Autor, Long>{

	List<Autor> findByNome(String nome);

	List<Autor> findByNomeContaining(String nome);
}
