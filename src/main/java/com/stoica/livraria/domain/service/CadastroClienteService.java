package com.stoica.livraria.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.exception.ClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfExistenteException;
import com.stoica.livraria.domain.exception.EmailExistenteException;
import com.stoica.livraria.domain.model.Cliente;
import com.stoica.livraria.domain.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class CadastroClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente encontrarCliente(String cpf) {
		return clienteRepository.findByCpf(cpf).orElseThrow(
				() -> new CpfClienteNaoEncontradoException(cpf));
	}
	
	public Cliente encontrarClienteId(Long id) {
		return clienteRepository.findById(id).orElseThrow(
				() -> new ClienteNaoEncontradoException(id));
	}
	
	@Transactional
	public Cliente salvarCliente (Cliente cliente, Boolean edicao) {
		
		if (!edicao) {
			clienteRepository.findByCpf(cliente.getCpf()).ifPresent(
					c -> {
						throw new CpfExistenteException(c.getCpf());
					});
			clienteRepository.findByEmail(cliente.getEmail()).ifPresent(
					c -> {
						throw new EmailExistenteException(c.getEmail());
					});
			
		} else if (edicao){
			Cliente clienteExistente = clienteRepository.findById(cliente.getId())
	                .orElseThrow(() -> new ClienteNaoEncontradoException(cliente.getId()));

	        if (!clienteExistente.getCpf().equals(cliente.getCpf())) {
	            clienteRepository.findByCpf(cliente.getCpf()).ifPresent(c -> {
	                throw new CpfExistenteException(c.getCpf());
	            });
	        }

	        if (!clienteExistente.getEmail().equals(cliente.getEmail())) {
	            clienteRepository.findByEmail(cliente.getEmail()).ifPresent(c -> {
	                throw new EmailExistenteException(c.getEmail());
	            });
	        }
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void editarCliente(Long id, Cliente cliente) {
	
		Cliente clienteAtual = encontrarClienteId(id);
		BeanUtils.copyProperties(cliente, clienteAtual, "id", "cpf", "email");
		salvarCliente(clienteAtual, true);
	
	}
	
	
	@Transactional
	public void removerCLiente(Long id) {
		
		if(clienteRepository.findById(id).isEmpty()) {
			throw new ClienteNaoEncontradoException(id);
		}
		
		clienteRepository.deleteById(id);
	}
	
	
}
