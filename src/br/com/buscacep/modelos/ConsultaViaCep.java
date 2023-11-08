package br.com.buscacep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaViaCep {
    private String consulta;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Endereco buscarCep(String cep){

        consulta = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(consulta)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            EnderecoViaCep enderecoViaCep = gson.fromJson(response.body(), EnderecoViaCep.class);

            Endereco endereco = new Endereco(enderecoViaCep);
            System.out.println(endereco);
            return endereco;
        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP!");
        }

    }
}
