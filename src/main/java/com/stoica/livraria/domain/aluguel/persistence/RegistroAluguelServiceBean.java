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
class RegistroAluguelServiceBean implements AluguelService{
	
	@Autowired
	AluguelRepository aluguelRepository;
	
	@Autowired
	LivroService livroService;
	
	@Override
	public List<Aluguel> listar(){
		return aluguelRepository.findAll();
	}
	
	@Override
	public Aluguel adicionar(Aluguel aluguel) {
		for(Livro livro : aluguel.getLivros()) {
			if("INDISPONIVEL".equals(livro.getStatus())) {
				throw new RuntimeException(livro.getTitulo() + " Está indisponivel");
			}
			livroService.alterarStatus(livro.getId());
		}
		return salvar(aluguel);
	}
	
	public void devolucao(Long id) {
		Aluguel aluguel = encontrarPeloId(id);
		for (Livro livro : aluguel.getLivros()) {
			livroService.alterarStatus(livro.getId());
		}
	}
	
	@Transactional
	private Aluguel salvar(Aluguel aluguel) {
		return aluguelRepository.save(aluguel);
	}
	
	@Override
	public Aluguel encontrarPeloId(Long id) {
		return aluguelRepository.findById(id).orElseThrow(
				() -> {
					throw new RuntimeException("Aluguel não encontrado Exception");
				});
	}

	@Override
	public void devolucaoParcial(Long id, List<Livro> livros) {
		// TODO Auto-generated method stub
		
	}

	
}
