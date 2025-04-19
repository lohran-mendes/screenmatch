package com.github.lohran_mendes.screenmatch.service;

import com.github.lohran_mendes.screenmatch.model.ResearchData;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class Api {
    @Value("${omdb.api.key}")
    private String apiKey;

    @Value("${omdb.api.base}")
    private String BASE_URL;

    Gson gson = new Gson();
    HttpClient CLIENT = HttpClient.newHttpClient();

    public ResearchData getBodyOf(String searchParam) {
        if (searchParam == null || searchParam.isBlank()) {
            throw new IllegalArgumentException("O parâmetro de pesquisa não pode ser nulo ou vazio!");
        }

        String encode = searchParam.replace(" ", "+");
        URI uri = URI.create(BASE_URL + "?apikey=" + apiKey + "&t=" + encode);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.body().contains("\"Response\":\"False\"")) {
                throw new RuntimeException("O 'filme/série' não foi encontrado ou teve erro na API.");
            }

            return gson.fromJson(response.body(), ResearchData.class);
        } catch (Exception e) {
            System.out.println("\nErro ao buscar os dados da API: " + e.getMessage());
            return null;
        }
    }


}
