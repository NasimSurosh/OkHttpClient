package com.example.HttpClient.Http_Client.HttpOk;

import okhttp3.*;

import java.io.IOException;


public class OkHttpPostMethod {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        // Create a resource
        MediaType jSON = MediaType.parse("application/json; charset=utf-8");
        String jsonBody = "{\"title\": \"Sample Title\", \"body\": \"Sample Body\", \"userId\": 1}";

        RequestBody requestBody = RequestBody.create(jSON, jsonBody);

        Request request = new Request.Builder().url("http:/jsonplaceholder.typicode.com/posts")
                .post(requestBody).build();

        try{
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                System.out.println("Post operation is successful");
                System.out.println("Response body: " + response.body().string());
            }
            else {
                System.out.println("Post operation is failed " + response.code());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
