package com.stoica.livraria.domain.livro;

import java.sql.Date;
import java.util.List;

import org.hibernate.validator.constraints.ISBN;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stoica.livraria.domain.autor.Autor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Livro {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ISBN
	private String ISBN;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String editora;
	
	@NotBlank
	private String descricao;

	private Date dataPublicacao;
	
	private String status;
	
	@JsonIgnoreProperties(value={"nome"}, allowGetters = true)
	@ManyToMany
	private List<Autor> autor;
}
