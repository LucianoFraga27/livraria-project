package com.stoica.livraria.domain.aluguel.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.aluguel.Aluguel;
import com.stoica.livraria.domain.aluguel.AluguelService;
import com.stoica.livraria.domain.livro.Livro;
import com.stoica.livraria.domain.livro.LivroService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroAluguelServiceBean implements AluguelService{
	
	@Autowired
	AluguelRepository aluguelRepository;
	
	@Autowired
	LivroService livroService;
	
	@Override
	public List<Aluguel> listar(){
		return aluguelRepository.findAll();
	}
	
	
	@Override
	@Transactional
	public Aluguel adicionar(Aluguel aluguel) {
		for(Livro livro : aluguel.getLivros()) {
			System.err.println(livro.getStatus());
			livroService.alterarStatus(livro.getId());
			System.err.println(livro.getStatus());
		}
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
