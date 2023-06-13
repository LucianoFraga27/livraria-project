package com.stoica.livraria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
