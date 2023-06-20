package com.stoica.livraria.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RegistroEmprestimoService {

	public  OffsetDateTime currentDateTime = OffsetDateTime.now();
	
}
