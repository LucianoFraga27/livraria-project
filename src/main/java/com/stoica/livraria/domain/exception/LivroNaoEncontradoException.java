package com.stoica.livraria.domain.exception;

public class LivroNaoEncontradoException extends NegocioException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static final String MENSAGEM_LIVRO_INEXISTENTE = "Livro com o ID '%l', não foi encontrado.";
	
	public LivroNaoEncontradoException(Long mensagem) {
		super(String.format(MENSAGEM_LIVRO_INEXISTENTE, mensagem)); 
	}


}
