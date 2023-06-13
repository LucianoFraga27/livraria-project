package com.stoica.livraria.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

@Service
public class RegistroEmprestimoService {

	public  OffsetDateTime currentDateTime = OffsetDateTime.now();
	
}
