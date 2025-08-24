package br.com.exemplo.ScrenMatch.model;

import br.com.exemplo.ScrenMatch.service.ConsultaChatGPT;
import lombok.*;

import java.util.OptionalDouble;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Serie {
    private String titulo;
    private Integer totalTemporada;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    public Serie(DadosSeries dadosSeries) {
        this.titulo = dadosSeries.Titulo();
        this.totalTemporada = dadosSeries.totalTemporada();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSeries.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSeries.genero().split(",")[0].trim());
        this.atores = dadosSeries.atores();
        this.poster = dadosSeries.poster();
        this.sinopse = ConsultaChatGPT.obterTraducao(dadosSeries.sinopse()).trim();
    }
}
