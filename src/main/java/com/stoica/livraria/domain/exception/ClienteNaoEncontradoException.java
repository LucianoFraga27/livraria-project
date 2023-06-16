package com.stoica.livraria.domain.exception;

public class ClienteNaoEncontradoException extends NegocioException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static final String MENSAGEM_AUTOR_INEXISTENTE = "Autor com o id ('%s'), não foi encontrado.";
	
	public ClienteNaoEncontradoException(Long mensagem) {
		super(String.format(MENSAGEM_AUTOR_INEXISTENTE, mensagem)); 
	}


}
