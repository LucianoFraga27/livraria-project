package com.stoica.livraria.utils.csv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModeloController {

	@Autowired
	ModeloService modeloService;
	
	@GetMapping("/obterdados")
	public List<Modelo> obterDados() {
		return modeloService.obterDados();
	}
}
