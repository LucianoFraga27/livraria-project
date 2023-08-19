package com.stoica.livraria.domain.aluguel;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stoica.livraria.domain.cliente.Cliente;
import com.stoica.livraria.domain.livro.Livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Aluguel {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "aluguel_livro",
        joinColumns = @JoinColumn(name = "aluguel_id"),
        inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;
	
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private OffsetDateTime data;
	
	private OffsetDateTime dataPrevistaDevolucao;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private OffsetDateTime dataDevolucao;
	
	// ATRASADO , ALUGADO, DEVOLVIDO
	private String status;
	
	 @PrePersist
	    public void prePersist() {
	        if (dataPrevistaDevolucao == null) {
	            // Definir a data prevista para devolução como 7 dias após a data atual
	            dataPrevistaDevolucao = OffsetDateTime.now().plusDays(7);
	        }
	    }
}
