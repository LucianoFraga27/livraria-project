package com.stoica.livraria.domain.cliente.rules;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoica.livraria.domain.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{


	Optional<Cliente> findByEmail(String email);
	
	Optional<Cliente> findByCpf(String cpf);
	

}
