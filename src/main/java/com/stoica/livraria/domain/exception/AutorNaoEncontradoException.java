package com.stoica.livraria.domain.exception;

public class AutorNaoEncontradoException extends NegocioException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static final String MENSAGEM_CLIENTE_INEXISTENTE = "Cliente com o id ('%s'), não foi encontrado.";
	
	public AutorNaoEncontradoException(Long mensagem) {
		super(String.format(MENSAGEM_CLIENTE_INEXISTENTE, mensagem)); 
	}


}
