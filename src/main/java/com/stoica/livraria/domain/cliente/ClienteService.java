package com.stoica.livraria.domain.cliente;

import java.util.List;

import jakarta.transaction.Transactional;

public interface ClienteService {

	List<Cliente> listarClientes();

	Cliente encontrarClientePeloCPF(String cpf);

	Cliente encontrarClientePeloID(Long id);

	Cliente salvarCliente(Cliente cliente);

	void editarCliente(Long id, Cliente cliente);

	void removerCLiente(Long id);

}