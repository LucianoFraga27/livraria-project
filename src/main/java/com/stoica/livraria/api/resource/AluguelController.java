package com.stoica.livraria.api.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.api.dto.aluguel.AluguelInputDTO;
import com.stoica.livraria.api.dto.livro.LivroInputAluguelDTO;
import com.stoica.livraria.domain.aluguel.Aluguel;
import com.stoica.livraria.domain.aluguel.AluguelService;
import com.stoica.livraria.domain.cliente.Cliente;
import com.stoica.livraria.domain.cliente.ClienteService;
import com.stoica.livraria.domain.livro.Livro;
import com.stoica.livraria.domain.livro.LivroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aluguel")
@RequiredArgsConstructor
public class AluguelController {

	
	private final AluguelService aluguelService;
	private final ClienteService clienteService;
	private final LivroService livroService;
	
	@GetMapping("")
	public List<Aluguel> listar(){
		return aluguelService.listar(); 
	}
	
	@PostMapping("")
	public Aluguel adicionar(@RequestBody AluguelInputDTO aluguel) {
		
		List<Livro> livrosEnviados = new ArrayList<>();
		
		for(LivroInputAluguelDTO livroId: aluguel.getLivros()) {
			livrosEnviados.add(livroService.encontrarLivroPeloID(livroId.getId()));
		}
	
		Cliente clienteEnviado = clienteService.encontrarClientePeloID(aluguel.getCliente().getId());
		
		Aluguel aluguelCriado = new Aluguel();
		
		aluguelCriado.setCliente(clienteEnviado);
		aluguelCriado.setLivros(livrosEnviados);
		
		aluguelService.adicionar(aluguelCriado);
		
		return aluguelCriado;
	}
	
	
	
}
