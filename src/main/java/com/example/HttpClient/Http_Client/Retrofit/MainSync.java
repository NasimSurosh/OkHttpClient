package com.example.HttpClient.Http_Client.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class MainSync {

    public static void main(String[] args) {

        //  create instance of api service using retrofit client
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);


        try{
            Call<User> call = apiService.getUserById(1);
            // synchronously execute http request and get response
            Response<User> response = call.execute();
            if(response.isSuccessful()){
                User user = response.body();
                System.out.println("User id: "+user.getId());
                System.out.println("User name: "+user.getName());
                System.out.println("User email: "+user.getEmail());
            }else{
                System.out.println("Failed to get user");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
