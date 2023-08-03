package com.stoica.livraria.domain.aluguel.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.aluguel.Aluguel;
import com.stoica.livraria.domain.aluguel.AluguelService;

@Service
public class RegistroAluguelServiceBean implements AluguelService{
	
	@Autowired
	AluguelRepository aluguelRepository;
	
	@Override
	public List<Aluguel> listar(){
		return aluguelRepository.findAll();
	}
	
	@Override
	public Aluguel adicionar(Aluguel aluguel) {
		return aluguelRepository.save(aluguel);
	}
	
	@Override
	public Aluguel encontrarPeloId(Long id) {
		return aluguelRepository.findById(id).orElseThrow(
				() -> {
					throw new RuntimeException("Aluguel não encontrado Exception");
				});
	}
	
}
