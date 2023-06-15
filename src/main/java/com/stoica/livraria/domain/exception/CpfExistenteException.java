package com.stoica.livraria.domain.exception;

public class CpfExistenteException extends NegocioException{
	
	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM_CPF_EXISTENTE = "CPF ('%s') já registrado";
	
	public CpfExistenteException(String mensagem) {
		super(String.format(MENSAGEM_CPF_EXISTENTE, mensagem)); 
	}

	


	
}
