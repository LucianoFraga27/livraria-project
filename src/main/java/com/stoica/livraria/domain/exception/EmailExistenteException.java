package com.stoica.livraria.domain.exception;

public class EmailExistenteException extends NegocioException{
	
	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM_EMAIL_EXISTENTE = "Email ('%s') já registrado";
	
	public EmailExistenteException(String mensagem) {
		super(String.format(MENSAGEM_EMAIL_EXISTENTE, mensagem)); 
	}

	


	
}
