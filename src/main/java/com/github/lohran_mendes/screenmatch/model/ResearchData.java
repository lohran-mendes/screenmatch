package com.github.lohran_mendes.screenmatch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record ResearchData(@SerializedName("Title") String titulo,
                           @SerializedName("Year") String ano,
                           @SerializedName("Rated") String classificacao,
                           @SerializedName("Released") String dataLancamento,
                           @SerializedName("Runtime") String duracao,
                           @SerializedName("Genre") String genero,
                           @SerializedName("Director") String diretor,
                           @SerializedName("Writer") String escritor,
                           @SerializedName("Actors") String atores,
                           @SerializedName("Plot") String sinopse,
                           @SerializedName("Language") String idioma,
                           @SerializedName("Country") String pais,
                           @SerializedName("Awards") String premios,
                           @SerializedName("Poster") String poster,
                           @SerializedName("Ratings") List<Rating> avaliacoes,
                           @SerializedName("Metascore") String metascore,
                           @SerializedName("imdbRating") double notaImdb,
                           @SerializedName("imdbVotes") String votosImdb,
                           @SerializedName("imdbID") String idImdb,
                           @SerializedName("Type") String tipo,
                           @SerializedName("totalSeasons") int totalTemporadas,
                           @SerializedName("Website") String site,
                           @SerializedName("DVD") String dvd,
                           @SerializedName("BoxOffice") String bilheteria,
                           @SerializedName("Production") String producao,
                           @SerializedName("Response") boolean resposta
) {

}
