package com.stoica.livraria.domain.aluguel;

import java.util.List;

import com.stoica.livraria.domain.livro.Livro;

public interface AluguelService {

	List<Aluguel> listar();
	Aluguel encontrarPeloId(Long id);
	Aluguel adicionar(Aluguel aluguel);
	void devolucao(Long id);
	void devolucaoParcial(Long idAluguel, Long[] idLivros);
	
}
