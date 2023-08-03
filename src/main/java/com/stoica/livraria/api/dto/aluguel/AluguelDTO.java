package com.stoica.livraria.api.dto.aluguel;

import java.time.OffsetDateTime;

public class AluguelDTO {

	Long id;
	
	// Informações dos Clientes
	String nomeCliente;
	String cpfCliente;
	String emailCliente;
	
	// Informações na Lista do Livro
	String titulo;
	String nomeAutor;
	
	// Informações do aluguel
	OffsetDateTime data;
	OffsetDateTime dataPrevistaParaEntrega;
	OffsetDateTime dataEntrega;
}
