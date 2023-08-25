package com.stoica.livraria.api.dto.aluguel;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

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

@Component
@RequiredArgsConstructor
public class AluguelMapper {

	private final AluguelService aluguelService;
	private final ClienteService clienteService;
	private final LivroService livroService;
	
	
	public List<AluguelOutputDTO> exibirTodos(){
		List<Aluguel> lista = aluguelService.listar();
		List<AluguelOutputDTO> alugueis = new ArrayList<AluguelOutputDTO>();
		
		
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
	
	
	public AluguelOutputDTO exibirAluguel(Long id) {
			
		Aluguel aluguel = aluguelService.encontrarPeloId(id);
		
		AluguelOutputDTO aluguelOutput = new AluguelOutputDTO();
		
		List<LivroOutputAluguelDTO> livrosOutput = new ArrayList<>();
		
		// Setando os livros
		for(Livro livroOutput: aluguel.getLivros()) {
			LivroOutputAluguelDTO livro = new LivroOutputAluguelDTO();
			livro.setId(livroOutput.getId());
			livro.setTitulo(livroOutput.getTitulo());
			livro.setEditora(livroOutput.getEditora());
			livrosOutput.add(livro);
		}
		
		ClienteOutputAluguelDTO cliente = new ClienteOutputAluguelDTO();
		
		cliente.setId(aluguel.getCliente().getId());
		cliente.setNome(aluguel.getCliente().getNome());
		cliente.setEmail(aluguel.getCliente().getEmail());
		
		aluguelOutput.setId(aluguel.getId());
		aluguelOutput.setCliente(cliente);
		aluguelOutput.setLivros(livrosOutput);
		aluguelOutput.setData(aluguel.getData());
		
		return aluguelOutput;
	}
	
	
	public AluguelOutputDTO adicionar(AluguelInputDTO aluguel) {
		
		List<Livro> livrosEnviados = new ArrayList<>();
		
		for(LivroInputAluguelDTO livroId: aluguel.getLivros()) {
			livrosEnviados.add(livroService.encontrarLivroPeloID(livroId.getId()));
		}
	
		Cliente clienteEnviado = clienteService.encontrarClientePeloID(aluguel.getCliente().getId());
		Aluguel aluguelCriado = new Aluguel();
		aluguelCriado.setCliente(clienteEnviado);
		aluguelCriado.setLivros(livrosEnviados);
		aluguelCriado.setStatus("ALUGADO");
		aluguelService.adicionar(aluguelCriado);
		
		AluguelOutputDTO aluguelOutput = new AluguelOutputDTO();
		ClienteOutputAluguelDTO clienteOutputAluguelDTO = new ClienteOutputAluguelDTO();
		
		clienteOutputAluguelDTO.setId(clienteEnviado.getId());
		clienteOutputAluguelDTO.setNome(clienteEnviado.getNome());
		clienteOutputAluguelDTO.setEmail(clienteEnviado.getEmail());
		
		aluguelOutput.setCliente(clienteOutputAluguelDTO);
		
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
	
		aluguelOutput.setLivros(livroOutputAluguelDTO);
		aluguelOutput.setId(aluguelCriado.getId());
		aluguelOutput.setData(OffsetDateTime.now());
		
		return aluguelOutput;
	}
	
	public void devolucao(Long id) {
		aluguelService.devolucao(id);
	}
	
	public void devolucaoParcial(Long id, ListaLivrosDevolucaoDTO listaLivrosDevolucao) {
		Long[] listaLivros = listaLivrosDevolucao.getIdLivros();
		aluguelService.devolucaoParcial(id, listaLivros);
	}
	
}
