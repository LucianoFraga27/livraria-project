package com.stoica.livraria.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{


	Optional<Cliente> findByEmail(String email);
	
	Optional<Cliente> findByCpf(String cpf);
	
	void deleteByCpf(String cpf);
	

}
