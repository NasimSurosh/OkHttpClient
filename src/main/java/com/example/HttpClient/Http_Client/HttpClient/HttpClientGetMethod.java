package com.example.HttpClient.Http_Client.HttpClient;

// what is http
// client server
// httpclient - introduced in java 11 it is used to send http request and receive http response
      // from web server it is powerful and flexible interacting with web server
// you can customise many parameters like header, timeout, authentication and other aspect
// part of java.net.http package
// restfull api = you can use http, FTP, smpt
// http client : you can access service only via http

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientGetMethod {
    public static void main(String[] args) {
        // create instance of httpclient
        HttpClient httpClient = HttpClient.newHttpClient();

        //define url of api to which i want to send request to

        String url = "https://jsonplaceholder.typicode.com/posts/2";
        String google = "https://www.google.com/";




        // create instance of httprequest with this ur

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET()  // to send GET request
                .build();

        try{
           // send httprequest and retrieve http response
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

            // print status code and body
            System.out.println("Status code "+httpResponse.statusCode());
            System.out.println("Response body "+httpResponse.body());

            // GET and print response headers
            HttpHeaders headers = httpResponse.headers();
            System.out.println("Response Headers ");
            headers.map().forEach((k,v)->System.out.println(k +" : " + v));
        }
        catch(IOException e){
            e.printStackTrace();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
