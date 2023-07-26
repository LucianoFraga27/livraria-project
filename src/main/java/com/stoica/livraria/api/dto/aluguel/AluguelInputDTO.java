package com.stoica.livraria.api.dto.aluguel;

import java.util.List;

import com.stoica.livraria.api.dto.cliente.ClienteInputAluguelDTO;
import com.stoica.livraria.api.dto.livro.LivroInputAluguelDTO;
import com.stoica.livraria.domain.livro.Livro;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AluguelInputDTO {
	
	@NotBlank
	private ClienteInputAluguelDTO cliente;
	
	@NotBlank
	private List<LivroInputAluguelDTO> livros;
	
}

/*COMPLETAR DTO. 
 * INSERIR MASSA DE DADOS PARA TESTE SERÁ A PRIMEIRA COISA A SE FAZER PÓS OS DTOS AFTERMIGRATE
 */