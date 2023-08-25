package com.stoica.livraria.domain.cliente;

import java.util.List;

public interface ClienteService {

	List<Cliente> listarClientes();

	Cliente encontrarClientePeloCPF(String cpf);

	Cliente encontrarClientePeloID(Long id);

	Cliente salvarCliente(Cliente cliente);

	Cliente editarCliente(Long id, Cliente cliente);

	void removerCLiente(Long id);

}