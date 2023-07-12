package com.stoica.livraria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoica.livraria.domain.model.Modelo;
import com.stoica.livraria.domain.service.ModeloService;

@RestController
public class ModeloController {

	@Autowired
	ModeloService modeloService;
	
	@GetMapping("/obterdados")
	public List<Modelo> obterDados() {
		return modeloService.obterDados();
	}
}
