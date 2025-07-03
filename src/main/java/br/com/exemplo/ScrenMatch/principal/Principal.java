package br.com.exemplo.ScrenMatch.principal;

import br.com.exemplo.ScrenMatch.model.DadosSeries;
import br.com.exemplo.ScrenMatch.model.DadosTemporadas;
import br.com.exemplo.ScrenMatch.service.ConsumoAPI;
import br.com.exemplo.ScrenMatch.service.CoverterDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumo = new ConsumoAPI();
    private CoverterDados converter = new CoverterDados();
    private Scanner sc = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=287d2366";


    public void exibeMenu() throws JsonProcessingException {
        System.out.print("Digite o nome da serie para a busca: ");
        String nome = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nome.replace(" ", "+") + API_KEY);
        DadosSeries dados = converter.obterDados(json, DadosSeries.class);
        System.out.println(dados);

        List<DadosTemporadas> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporada(); i++) {
            json = consumo.obterDados(ENDERECO + nome.replace(" ", "+") + "&season="+ i + API_KEY);
            var dadostemporadas = converter.obterDados(json, DadosTemporadas.class);
            temporadas.add(dadostemporadas);
        }
        temporadas.forEach(System.out::println);

    }
}
