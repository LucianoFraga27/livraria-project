package com.stoica.livraria.api.dto.aluguel;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stoica.livraria.api.dto.cliente.ClienteOutputAluguelDTO;
import com.stoica.livraria.api.dto.livro.LivroOutputAluguelDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class AluguelOutputDTO {

	private Long id;
	
	private ClienteOutputAluguelDTO cliente;
	
	private List<LivroOutputAluguelDTO> livros;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private OffsetDateTime data;
	
}
