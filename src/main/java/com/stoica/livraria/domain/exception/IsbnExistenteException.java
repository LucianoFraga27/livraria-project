package com.stoica.livraria.domain.exception;

public class IsbnExistenteException extends NegocioException{
	
	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM_ISBN_EXISTENTE = "Um livro já foi registrado utilizando esse ISBN ('%s').";
	
	public IsbnExistenteException(String mensagem) {
		super(String.format(MENSAGEM_ISBN_EXISTENTE, mensagem)); 
	}

	


	
}
