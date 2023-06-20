package com.stoica.livraria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.domain.model.Cliente;
import com.stoica.livraria.domain.service.CadastroClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	CadastroClienteService clienteService;
	
	@GetMapping
	public String sobreClientes() {
		return "Endpoint /clientes (explicar um pouco sobre esse endpoint)";
	}
	
	@GetMapping("/todos")
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}

	@GetMapping("/cpf/{cpf}")
	public Cliente encontrarClientePeloCPF(@PathVariable(value="cpf") String cpf){
		return clienteService.encontrarClientePeloCPF(cpf);
	}
	
	@GetMapping("/id/{id}")
	public  Cliente encontrarClientePeloID(@PathVariable(value="id") Long id){
		return clienteService.encontrarClientePeloID(id);
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/adicionar")
	public Cliente adicionarCliente( @RequestBody @Valid Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerCliente(@PathVariable(value="id") Long id) {
		clienteService.removerCLiente(id);
		return ResponseEntity.ok("Deletado com sucesso");
	}
	
	@PutMapping("/editar/{id}")
	public void editarCliente(@PathVariable(value="id") Long id, @RequestBody @Valid Cliente cliente ) {
		clienteService.editarCliente(id, cliente);
	}
	
}
