package com.stoica.livraria.api.exception;

import java.net.URI;
import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stoica.livraria.domain.exception.AutorNaoEncontradoException;
import com.stoica.livraria.domain.exception.ClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfClienteNaoEncontradoException;
import com.stoica.livraria.domain.exception.CpfExistenteException;
import com.stoica.livraria.domain.exception.EmailExistenteException;
import com.stoica.livraria.domain.exception.IsbnExistenteException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoIDException;
import com.stoica.livraria.domain.exception.LivroNaoEncontradoISBNException;
import com.stoica.livraria.domain.exception.NegocioException;
import com.stoica.livraria.domain.exception.NenhumAutorEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CpfExistenteException.class)
	ProblemDetail handleCpfExistenteException(CpfExistenteException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-ja-existente"));
		problemDetail.setTitle("CPF Já Cadastrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(EmailExistenteException.class)
	ProblemDetail handleEmailExistenteException(EmailExistenteException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-ja-existente"));
		problemDetail.setTitle("Email Já Cadastrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(IsbnExistenteException.class)
	ProblemDetail handleIsbnExistenteException(IsbnExistenteException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-ja-existente"));
		problemDetail.setTitle("ISBN Já Cadastrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(NegocioException.class)
	ProblemDetail handleNegocioException(NegocioException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_ACCEPTABLE, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/regra-violada"));
		problemDetail.setTitle("Regra Violada");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        problemDetail.setProperty("message", "Desculpe, parece que ocorreu um erro na sua requisição. Por favor, verifique os dados informados e tente novamente. Se o problema persistir, entre em contato com o suporte técnico para obter assistência.");
        return problemDetail;
	}
	
	@ExceptionHandler(LivroNaoEncontradoISBNException.class)
	ProblemDetail handleLivroNaoEncontradoISBNException(LivroNaoEncontradoISBNException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-inexistente"));
		problemDetail.setTitle("Livro Não Encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(LivroNaoEncontradoIDException.class)
	ProblemDetail handleLivroNaoEncontradoIDException(LivroNaoEncontradoIDException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-inexistente"));
		problemDetail.setTitle("Livro Não Encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	ProblemDetail handleAutorNaoEncontradoException(AutorNaoEncontradoException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-inexistente"));
		problemDetail.setTitle("Autor Não Encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(NenhumAutorEncontradoException.class)
	ProblemDetail handleNenhumAutorEncontradoException(NenhumAutorEncontradoException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-inexistente"));
		problemDetail.setTitle("Nenhum Autor foi Encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(CpfClienteNaoEncontradoException.class)
	ProblemDetail handleCpfClienteNaoEncontradoException(CpfClienteNaoEncontradoException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-inexistente"));
		problemDetail.setTitle("Cliente Não Encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	ProblemDetail handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
		var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.toString());
		problemDetail.setType(URI.create("https://api.livraria.com/errors/entidade-inexistente"));
		problemDetail.setTitle("Cliente Não Encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("TimeStamp", OffsetDateTime.now());
        return problemDetail;
	}
		
}
