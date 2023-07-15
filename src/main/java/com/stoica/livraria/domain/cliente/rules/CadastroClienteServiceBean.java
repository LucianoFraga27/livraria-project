package com.stoica.livraria.domain.cliente.rules;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.cliente.Cliente;
import com.stoica.livraria.domain.cliente.ClienteService;
import com.stoica.livraria.domain.exception.ClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfExistenteException;
import com.stoica.livraria.domain.exception.EmailExistenteException;

import jakarta.transaction.Transactional;

@Service
class CadastroClienteServiceBean implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente encontrarClientePeloCPF(String cpf) {
		return clienteRepository.findByCpf(cpf).orElseThrow(
				() -> new CpfClienteNaoEncontradoException(cpf));
	}
	
	public Cliente encontrarClientePeloID(Long id) {
		return clienteRepository.findById(id).orElseThrow(
				() -> new ClienteNaoEncontradoException(id));
	}
	
	@Transactional
	public Cliente salvarCliente (Cliente cliente) {
			clienteRepository.findByCpf(cliente.getCpf()).ifPresent(
					c -> {
						throw new CpfExistenteException(c.getCpf());
					});
			clienteRepository.findByEmail(cliente.getEmail()).ifPresent(
					c -> {
						throw new EmailExistenteException(c.getEmail());
					});
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void editarCliente(Long id, Cliente cliente) {
		
		Cliente clienteAtual = encontrarClientePeloID(id);
	
		
		if (!clienteAtual.getCpf().equals(cliente.getCpf())) {
			clienteRepository.findByCpf(cliente.getCpf()).ifPresent(
					c -> {
						throw new CpfExistenteException(c.getCpf());
					});
		}
		
		if (!clienteAtual.getEmail().equals(cliente.getEmail())) {
	        clienteRepository.findByEmail(cliente.getEmail()).ifPresent(c -> {
	            throw new EmailExistenteException(c.getEmail());
	        });
	    }
		
		BeanUtils.copyProperties(cliente, clienteAtual, "id");

		clienteRepository.save(clienteAtual);
		
	}
	
	@Transactional
	public void removerCLiente(Long id) {
		if(clienteRepository.findById(id).isEmpty()) {
			throw new ClienteNaoEncontradoException(id);
		}
		clienteRepository.deleteById(id);
	}
	
	
}
