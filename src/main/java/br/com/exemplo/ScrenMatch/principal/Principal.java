package br.com.exemplo.ScrenMatch.principal;

import br.com.exemplo.ScrenMatch.model.DadosEpisodio;
import br.com.exemplo.ScrenMatch.model.DadosSeries;
import br.com.exemplo.ScrenMatch.model.DadosTemporadas;
import br.com.exemplo.ScrenMatch.service.ConsumoAPI;
import br.com.exemplo.ScrenMatch.service.CoverterDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;
import java.util.stream.Collectors;

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

//        for (int i = 0; i < dados.totalTemporada(); i++) {
//            List<DadosEpisodio> episodios = temporadas.get(i).dadosEpisodios();
//            for (int j = 0 ; j < episodios.size(); j++) {
//                System.out.println(episodios.get(j).Titulo());
//            }
//        }

        temporadas.forEach(t -> t.dadosEpisodios().forEach(e -> System.out.println(e.Titulo())));

//        List<String> nomes = Arrays.asList("iarley", "Matheus", "jose", "carlinhos", "Aninha");
//
//        nomes.stream()
//                .forEach(name -> System.out.println("olá " + name));
//        List<Integer> numeros =  Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> numeroPares = numeros.stream()
//                        .filter(n -> n % 2 == 0)
//                .collect(Collectors.toList());
//
//        System.out.println(numeroPares);
//        nomes.stream()
//                .sorted()
//                .limit(3)
//                .filter(n -> n.startsWith("M")) // Filtra os nomes que começam com "M"
//                .map(n -> n.toUpperCase()) //Transforma os nomes restantes em caixa alta
//                .forEach(System.out::println);


        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.dadosEpisodios().stream())
                .collect(Collectors.toList());


        System.out.println("\nTop 5 episodios: ");

        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

    }
}
