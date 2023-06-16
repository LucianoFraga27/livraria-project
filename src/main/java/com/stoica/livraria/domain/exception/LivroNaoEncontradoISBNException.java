package com.stoica.livraria.domain.exception;

public class LivroNaoEncontradoISBNException extends NegocioException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static final String MENSAGEM_LIVRO_INEXISTENTE_ISBN = "Livro com o ISBN '%l', não foi encontrado.";
	
	public LivroNaoEncontradoISBNException(String mensagem) {
		super(String.format(MENSAGEM_LIVRO_INEXISTENTE_ISBN, mensagem)); 
	}


}
