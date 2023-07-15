package com.stoica.livraria.utils.csv;

import java.sql.Date;
import java.util.List;

import org.hibernate.validator.constraints.ISBN;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Modelo {

	private Long id;
	private String titulo;
	private String autor;
	
	
}
