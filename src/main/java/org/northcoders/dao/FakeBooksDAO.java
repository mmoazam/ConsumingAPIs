package org.northcoders.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FakeBooksDAO {
    private static final String BASE_URL = "https://fakerapi.it/api/v1/books";


    public static Results getBooks(int quantity) throws JsonProcessingException {
        HttpResponse<String> httpResponse = null;
        ObjectMapper mapper = new ObjectMapper();

        String uri = getBuildUrl(quantity);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET().build();

            httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return mapper.readValue(httpResponse.body(), Results.class);

    } // end of method

    private static String getBuildUrl(int quantity) {
        StringBuilder sb = new StringBuilder();

        String quantityString = "";
        if(quantity != 0) {
            quantityString = "&_quantity=" + quantity;
        }

        return sb.append(BASE_URL).append("?").append(quantityString).toString();
    }
} // end of class
