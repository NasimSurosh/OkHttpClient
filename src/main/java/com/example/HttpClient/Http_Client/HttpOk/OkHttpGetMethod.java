package com.example.HttpClient.Http_Client.HttpOk;
// open source http client used for java and android development
// it supports async and synchronous http request
// it does not come with jdk.
// supports connection poling
// retrofit : this okhttp has a easy integration with retrofit

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class OkHttpGetMethod {
    public static void main(String[] args) {

        // create  okhttp
        OkHttpClient client = new OkHttpClient();

        // create a request by specifying the url

        Request request = new Request.Builder().url("http:/jsonplaceholder.typicode.com/posts/1").build();

        try{
            // use the client to execute request synchronously

            Response response = client.newCall(request).execute();

            // check id the request was successful(status code 200)
            if(response.isSuccessful()){

                ResponseBody body = response.body();
                if(body != null){
                    // get the response body as a string
                    String content = body.string();
                    System.out.println("Response body " + content);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        client.dispatcher().executorService().shutdown();


    }
}
