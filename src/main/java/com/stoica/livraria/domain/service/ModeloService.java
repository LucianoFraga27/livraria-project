package com.stoica.livraria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoica.livraria.domain.model.Modelo;
import com.stoica.livraria.domain.repository.LivroRepositoryJDBC;
import com.stoica.livraria.domain.util.GerarCsv;

@Service
public class ModeloService {

	@Autowired
	LivroRepositoryJDBC livroRepositoryJDBC;

	
	public List<Modelo> obterDados() {
		return livroRepositoryJDBC.obterDados();
	}
	
	
	
}
