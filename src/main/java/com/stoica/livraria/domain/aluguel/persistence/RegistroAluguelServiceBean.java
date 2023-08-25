package com.stoica.livraria.domain.aluguel.persistence;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@Transactional
	public void devolucao(Long id) {
		Aluguel aluguel = encontrarPeloId(id);
		for (Livro livro : aluguel.getLivros()) {
			livroService.alterarStatus(livro.getId());
		}
		aluguel.setDataDevolucao(OffsetDateTime.now());
		aluguel.setStatus("FINALIZADO");
	}
	
	@Transactional
	@Override
	public void devolucaoParcial(Long idAluguel, Long[] idLivros) {
		Set<Long> livrosSelecionados = new HashSet<>();
		if(idLivros.length > 0) {
			Aluguel aluguel = encontrarPeloId(idAluguel);
			List<Livro> livros = aluguel.getLivros();
			for(int i = 0; i < livros.size() ; i++ ) {
				for(int j = 0; j < idLivros.length ; j ++) {
					if (livros.get(i).getId().equals(idLivros[j])) {
						livrosSelecionados.add(idLivros[j]);
	                } else {
	                	System.err.println("Livro ID " + idLivros[j] + " não foi registrado nesse Aluguel.");
	                }
				}
			}
			for (Long livro : livrosSelecionados) {
				livroService.alterarStatus(livro);
				System.out.println("Livro ID " + livro + " -> DEVOLVIDO.");
			}
			aluguel.setStatus("PENDENTE");
		} else {
			System.err.println("Nenhum livro foi informado.");
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

	
}
