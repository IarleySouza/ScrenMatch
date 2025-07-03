package br.com.exemplo.ScrenMatch;

import br.com.exemplo.ScrenMatch.model.DadosEpisodio;
import br.com.exemplo.ScrenMatch.model.DadosSeries;
import br.com.exemplo.ScrenMatch.model.DadosTemporadas;
import br.com.exemplo.ScrenMatch.service.ConsumoAPI;
import br.com.exemplo.ScrenMatch.service.CoverterDados;
import br.com.exemplo.ScrenMatch.service.IconverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScrenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<DadosTemporadas> temporadas = new ArrayList<>();


		for (int i = 1; i <= dados.totalTemporada(); i++) {
			json = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" +i+ "&apikey=287d2366");
			var dadostemporadas = converter.obterDados(json, DadosTemporadas.class);
			temporadas.add(dadostemporadas);
		}
		temporadas.forEach(System.out::println);
	}
}
