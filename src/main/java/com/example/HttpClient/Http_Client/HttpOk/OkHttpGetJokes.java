package com.example.HttpClient.Http_Client.HttpOk;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class OkHttpGetJokes {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.chucknorris.io/jokes/random").build();

        try{
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String responseData = response.body().string();
                JSONObject jsonObject = new JSONObject(responseData);
                String jokes = jsonObject.getString("value");
                System.out.println("Requested joke is " + jokes + "\n");
            }else{
                System.out.println("Request failed");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
