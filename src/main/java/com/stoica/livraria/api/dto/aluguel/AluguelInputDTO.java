package com.stoica.livraria.api.dto.aluguel;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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
