package com.stoica.livraria.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.repository.LivroRepository;

@Service
public class CadastroLivroService {

	@Autowired
	LivroRepository livroRepository;
	
	
}
