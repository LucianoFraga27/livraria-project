package com.stoica.livraria.domain.aluguel;

import java.util.List;

public interface AluguelService {

	List<Aluguel> listar();
	
	Aluguel adicionar(Aluguel aluguel);
	
}
