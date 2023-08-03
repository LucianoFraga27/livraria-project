package com.stoica.livraria.api.resource;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.api.dto.aluguel.AluguelInputDTO;
import com.stoica.livraria.api.dto.aluguel.AluguelMapper;
import com.stoica.livraria.api.dto.aluguel.AluguelOutputDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aluguel")
@RequiredArgsConstructor
public class AluguelController {
	
	private final AluguelMapper aluguelMapper;
	
	@GetMapping("")
	public List<AluguelOutputDTO> listar(){
		return aluguelMapper.exibirTodos();
	}
	
	
	@GetMapping("/{id}")
	public AluguelOutputDTO encontrarPeloId(@PathVariable("id") Long id) {
		return aluguelMapper.exibirAluguel(id);
	}
	
	
	@PostMapping("")
	public AluguelOutputDTO adicionar(@RequestBody AluguelInputDTO aluguel) {
		return aluguelMapper.adicionar(aluguel);
	}
	
	
	
}
