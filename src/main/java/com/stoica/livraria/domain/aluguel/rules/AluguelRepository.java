package com.stoica.livraria.domain.aluguel.rules;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.aluguel.Aluguel;

interface AluguelRepository extends JpaRepository<Aluguel, Long>{

}
