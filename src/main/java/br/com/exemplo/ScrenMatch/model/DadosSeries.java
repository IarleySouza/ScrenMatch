package br.com.exemplo.ScrenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries(@JsonAlias("Title") String Titulo,
                          @JsonAlias("totalSeasons") Integer totalTemporada,
                          @JsonAlias("imdbRating") String avaliacao) {
}
