package com.stoica.livraria.domain.exception;

public class NenhumAutorEncontradoException extends NegocioException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static final String MENSAGEM_CLIENTE_INEXISTENTE = "Cliente com o id ('%s'), não foi encontrado.";
	
	public NenhumAutorEncontradoException(Long mensagem) {
		super(String.format(MENSAGEM_CLIENTE_INEXISTENTE, mensagem)); 
	}

	public NenhumAutorEncontradoException(String string) {
		super(String.format(MENSAGEM_CLIENTE_INEXISTENTE, string)); 
	}


}
