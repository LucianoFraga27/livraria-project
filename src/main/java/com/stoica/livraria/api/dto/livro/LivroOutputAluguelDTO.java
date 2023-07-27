package com.stoica.livraria.api.dto.livro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LivroOutputAluguelDTO {

	Long id;
	String titulo;
	String editora;
	
}
