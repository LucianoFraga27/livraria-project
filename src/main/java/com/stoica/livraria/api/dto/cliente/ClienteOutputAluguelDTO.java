package com.stoica.livraria.api.dto.cliente;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteOutputAluguelDTO {

	Long id;
	String nome;
	String email;
}
