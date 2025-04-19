package com.github.lohran_mendes.screenmatch;

import com.github.lohran_mendes.screenmatch.model.ResearchData;
import com.github.lohran_mendes.screenmatch.service.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    @Autowired
    private Api api;
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nSeja bem vindo ao Screenmatch!");
        System.out.println("Digite um filme ou séria para realizar a pesquisa:");
        String opcao = scanner.nextLine();
        ResearchData retornoDaPesquisa = api.getBodyOf(opcao);
        if (retornoDaPesquisa != null) {
            System.out.println("\nTipo de pesquisa: " + (retornoDaPesquisa.tipo().equals("movie") ? "filme" : retornoDaPesquisa.tipo().equals("series") ? "série" : retornoDaPesquisa.tipo()));
            System.out.println("Retorno da pesquisa: " + retornoDaPesquisa);
        } else {
            System.out.println("\nRetorno da pesquisa inválido!");
        }

    }

}
