package com.example.HttpClient.Http_Client.HttpClient;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDeleteMethod {

    public static void main(String[] args) {

        HttpClient httpClient = HttpClient.newHttpClient();

        String url = "https://jsonplaceholder.typicode.com/posts/2";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .header("Content-Type", "application/json")
                .DELETE().build();
        try{
            HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
