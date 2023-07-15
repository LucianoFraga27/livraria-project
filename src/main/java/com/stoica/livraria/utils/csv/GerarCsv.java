package com.stoica.livraria.utils.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GerarCsv {

	public void gerarArquivoCSV(List<Modelo> dados, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Escrever o cabeçalho do CSV
            writer.write("ID;Título;Autor\n");

            // Escrever os dados no arquivo CSV
            for (Modelo modelo : dados) {
                writer.write(String.format("%d;\"%s\";\"%s\"\n", modelo.getId(), modelo.getTitulo(), modelo.getAutor()));
            }

            System.err.println("Arquivo CSV gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo CSV: " + e.getMessage());
        }
        
    }
}
