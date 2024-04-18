package com.example.HttpClient.Http_Client.HttpOk;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpDeleteMethod {
    public static void main(String[] args)  {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("http:/jsonplaceholder.typicode.com/posts/1").delete().build();

        try{
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                System.out.println("ID deleted successfully");
                System.out.println(response.body().string());
            }else {
                System.out.println("Error deleting post");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
