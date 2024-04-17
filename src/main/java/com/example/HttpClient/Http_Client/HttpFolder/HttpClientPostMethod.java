package com.example.HttpClient.Http_Client.HttpFolder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientPostMethod {



        public static void main(String[] args) {
            // create instance of httpclient
            HttpClient httpClient = HttpClient.newHttpClient();

            //define url of api to which i want to send request to

            String url = "https://jsonplaceholder.typicode.com/posts";
           // String google = "https://www.google.com/";

            // define json payload for new resource
            String jsonBody =  "{\"userId\": 200, \"title\": \"New Post\", \"body\": \"New Post Body\"}";

            // create instance of httprequest with this url with post method
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url))
                    .headers("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

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
