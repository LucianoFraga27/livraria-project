package com.stoica.livraria.api.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.domain.aluguel.Aluguel;
import com.stoica.livraria.domain.aluguel.AluguelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aluguel")
@RequiredArgsConstructor
public class AluguelController {

	
	private final AluguelService aluguelService;
	
	@GetMapping("")
	public List<Aluguel> listar(){
		return aluguelService.listar(); 
	}
	
	@PostMapping("")
	public Aluguel adicionar(@RequestBody Aluguel aluguel) {
		return aluguelService.adicionar(aluguel);
	}
	
	
	
}
