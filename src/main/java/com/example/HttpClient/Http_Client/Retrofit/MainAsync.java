package com.example.HttpClient.Http_Client.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainAsync {
    public static void main(String[] args) {

        //  create instance of api service using retrofit client
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        // create a call object to represent HTTP GET
        // request to retrieve user data

        Call<User> userCall = apiService.getUserById(3);

        // Call<List<Repo>> repos = service.listRepos("octocat");

        // asynchronously enqueue the http request and define call back for success and failure
        userCall.enqueue(new Callback<User>() {

            @Override
            // this callback method is called when we have successful http request
            public void onResponse(Call<User> call, Response<User> response) {
                // check if response is successful(HTTP status code 2XX)
                if (response.isSuccessful()) {
                    // Extract user object from response body
                    User user = response.body();
                    System.out.println("User id: "+user.getId());
                    System.out.println("User name: "+user.getName());
                    System.out.println("User email: "+user.getEmail());
                }else{
                    System.out.println(response.message());
                }

            }

            @Override
            // this method with http failure
            public void onFailure(Call<User> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
