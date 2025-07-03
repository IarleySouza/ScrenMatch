package br.com.exemplo.ScrenMatch.principal;

import br.com.exemplo.ScrenMatch.model.DadosSeries;
import br.com.exemplo.ScrenMatch.service.ConsumoAPI;
import br.com.exemplo.ScrenMatch.service.CoverterDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumo = new ConsumoAPI();
    private CoverterDados converter = new CoverterDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=287d2366";


    public void exibeMenu() throws JsonProcessingException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da serie para a busca: ");
        String nome = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nome.replace(" ", "+") + API_KEY);


        DadosSeries dados = converter.obterDados(json, DadosSeries.class);
        System.out.println(dados);

    }
}
