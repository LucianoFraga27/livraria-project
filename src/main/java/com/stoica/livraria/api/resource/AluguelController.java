package com.stoica.livraria.api.resource;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.api.dto.aluguel.AluguelInputDTO;
import com.stoica.livraria.api.dto.aluguel.AluguelOutputDTO;
import com.stoica.livraria.api.dto.cliente.ClienteOutputAluguelDTO;
import com.stoica.livraria.api.dto.livro.LivroInputAluguelDTO;
import com.stoica.livraria.api.dto.livro.LivroOutputAluguelDTO;
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
	public List<AluguelOutputDTO> listar(){
		
		List<Aluguel> lista = aluguelService.listar();
		List<AluguelOutputDTO> alugueis = new ArrayList();
		
		
		for (Aluguel item:lista) {
			AluguelOutputDTO aluguel = new AluguelOutputDTO();
			List<LivroOutputAluguelDTO> livrosOutput = new ArrayList<>();
			
			// Setando os livros
			for(Livro livroOutput: item.getLivros()) {
				LivroOutputAluguelDTO livro = new LivroOutputAluguelDTO();
				livro.setId(livroOutput.getId());
				livro.setTitulo(livroOutput.getTitulo());
				livro.setEditora(livroOutput.getEditora());
				livrosOutput.add(livro);
			}
			
			ClienteOutputAluguelDTO cliente = new ClienteOutputAluguelDTO();
			
			cliente.setId(item.getCliente().getId());
			cliente.setNome(item.getCliente().getNome());
			cliente.setEmail(item.getCliente().getEmail());
			
			aluguel.setId(item.getId());
			aluguel.setCliente(cliente);
			aluguel.setLivros(livrosOutput);
			aluguel.setData(item.getData());
			
			alugueis.add(aluguel);
		}
		return alugueis;
		
	}
	
	@PostMapping("")
	public AluguelOutputDTO adicionar(@RequestBody AluguelInputDTO aluguel) {
		
		List<Livro> livrosEnviados = new ArrayList<>();
		
		for(LivroInputAluguelDTO livroId: aluguel.getLivros()) {
			livrosEnviados.add(livroService.encontrarLivroPeloID(livroId.getId()));
		}
	
		Cliente clienteEnviado = clienteService.encontrarClientePeloID(aluguel.getCliente().getId());
		
		Aluguel aluguelCriado = new Aluguel();
		
		aluguelCriado.setCliente(clienteEnviado);
		aluguelCriado.setLivros(livrosEnviados);
		
		aluguelService.adicionar(aluguelCriado);
		
		AluguelOutputDTO aluguelOutput = new AluguelOutputDTO();
		

		ClienteOutputAluguelDTO clienteOutputAluguelDTO = new ClienteOutputAluguelDTO();
		clienteOutputAluguelDTO.setId(clienteEnviado.getId());
		clienteOutputAluguelDTO.setNome(clienteEnviado.getNome());
		clienteOutputAluguelDTO.setEmail(clienteEnviado.getEmail());
		
		List<LivroOutputAluguelDTO> livroOutputAluguelDTO =  new ArrayList<>();
		
		for (LivroInputAluguelDTO livroId: aluguel.getLivros()) {
			LivroOutputAluguelDTO livroOutput = new LivroOutputAluguelDTO();
			Livro livro = livroService.encontrarLivroPeloID(livroId.getId());
			System.out.println(livro);
			livroOutput.setId(livro.getId());
			livroOutput.setTitulo(livro.getTitulo());
			livroOutput.setEditora(livro.getEditora());
			System.out.println(livroOutput.toString());
			livroOutputAluguelDTO.add(livroOutput);
			
		}
		
		aluguelOutput.setId(aluguelCriado.getId());
		aluguelOutput.setCliente(clienteOutputAluguelDTO);
		aluguelOutput.setLivros(livroOutputAluguelDTO);
		aluguelOutput.setData(OffsetDateTime.now());
		
		aluguelService.adicionar(aluguelCriado);
		
		return aluguelOutput;
	}
	
	
	
}
