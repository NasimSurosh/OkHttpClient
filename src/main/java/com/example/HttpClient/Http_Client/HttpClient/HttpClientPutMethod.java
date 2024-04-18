package com.example.HttpClient.Http_Client.HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientPutMethod {

    public static void main(String[] args) {

        HttpClient httpClient = HttpClient.newHttpClient();

        String url = "https://jsonplaceholder.typicode.com/posts/2";


        String putJson = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 2,\n" +
                "  \"title\": \"Calado elclasico\",\n" +
                "  \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
                "}";

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(putJson)).build();
        try {

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
