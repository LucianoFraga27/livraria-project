package com.stoica.livraria.domain.exception;

public class LivroIndisponivel extends NegocioException{
	
	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM_LIVRO_INDISPONIVEL = "O Livro '%s' está indisponivel.";
	
	public LivroIndisponivel(String mensagem) {
		super(String.format(MENSAGEM_LIVRO_INDISPONIVEL, mensagem)); 
	}
	
	public LivroIndisponivel(String mensagem, Long id) {
		super(String.format(MENSAGEM_LIVRO_INDISPONIVEL, mensagem, id)); 
	}
	
}
