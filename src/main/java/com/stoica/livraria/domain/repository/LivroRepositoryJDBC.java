package com.stoica.livraria.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stoica.livraria.domain.model.Modelo;
import com.stoica.livraria.domain.util.GerarCsv;

@Repository
public class LivroRepositoryJDBC {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private GerarCsv gerarCSV;
	
	public List<Modelo> obterDados() {
	    String query = 
	            "SELECT livro.id, livro.titulo, autor.nome AS nome_autor " +
	            "FROM livro " +
	            "JOIN livro_autor ON livro.id = livro_autor.livro_id " +
	            "JOIN autor ON livro_autor.autor_id = autor.id";
	    
	    List<Modelo> resultados = jdbcTemplate.query(query, (resultSet, rowNum) -> {
	        Modelo modelo = new Modelo();
	        
	        modelo.setId(resultSet.getLong("id"));
	        modelo.setTitulo(resultSet.getString("titulo"));
	        modelo.setAutor(resultSet.getString("nome_autor")); // Corrigido para "nome_autor"
	        
	        return modelo;
	    });
	    
	    gerarCSV.gerarArquivoCSV(resultados, "C:\\desenv\\java-workspace\\livraria\\livraria\\src\\main\\java\\com\\stoica\\livraria\\domain\\util\\arquivo.csv");
	    
	    return resultados;
	}
	
}
