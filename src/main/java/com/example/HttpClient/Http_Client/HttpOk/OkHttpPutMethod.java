package com.example.HttpClient.Http_Client.HttpOk;

import okhttp3.*;

import java.io.IOException;

public class OkHttpPutMethod {

    public static void main(String[] args) {

       OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        String edit = "{\"title\": \"new title\", \"body\": \"new sample body\", \"userId\": 3}";

        RequestBody requestBody = RequestBody.create(mediaType, edit);

        Request request = new Request.Builder().url("http:/jsonplaceholder.typicode.com/posts/4")
                .put(requestBody).build();

        try{
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                System.out.println("Edited successfully");
                System.out.println(response.body().string());
            }
            else{
                System.out.println("Edite failed" + response.code());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
