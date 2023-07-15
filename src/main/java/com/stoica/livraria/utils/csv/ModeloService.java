package com.stoica.livraria.utils.csv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

	@Autowired
	LivroRepositoryJDBC livroRepositoryJDBC;

	
	public List<Modelo> obterDados() {
		return livroRepositoryJDBC.obterDados();
	}
	
	
	
}
