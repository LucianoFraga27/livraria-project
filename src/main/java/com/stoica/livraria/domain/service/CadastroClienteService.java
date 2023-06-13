package com.stoica.livraria.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.exception.ClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfExistenteException;
import com.stoica.livraria.domain.model.Cliente;
import com.stoica.livraria.domain.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class CadastroClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente encontrarCliente(String cpf) {
		return clienteRepository.findByCpf(cpf).orElseThrow(
				() -> new ClienteNaoEncontradoException(cpf));
	}
	
	@Transactional
	void adicionarCliente (Cliente cliente) {
		clienteRepository.findByCpf(cliente.getCpf()).ifPresent(
				c -> {
					throw new CpfExistenteException(c.getCpf());
				});
		clienteRepository.save(cliente);
	}
	
	@Transactional
	void removerCLiente (String cpf) {
		try {
			clienteRepository.deleteByCpf(cpf);
		} catch (EmptyResultDataAccessException  e) {
			throw new ClienteNaoEncontradoException(cpf);
		}
	}
	
	
}
