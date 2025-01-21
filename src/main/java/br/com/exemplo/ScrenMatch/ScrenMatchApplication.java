package br.com.exemplo.ScrenMatch;

import br.com.exemplo.ScrenMatch.model.DadosSeries;
import br.com.exemplo.ScrenMatch.service.ConsumoAPI;
import br.com.exemplo.ScrenMatch.service.CoverterDados;
import br.com.exemplo.ScrenMatch.service.IconverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoapi = new ConsumoAPI();
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=287d2366");
		System.out.println(json);

		CoverterDados converter = new CoverterDados();
		DadosSeries dados = converter.obterDados(json, DadosSeries.class);
		System.out.println(dados);
	}
}
