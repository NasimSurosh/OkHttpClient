package com.example.HttpClient.Http_Client.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPut {
    public static void main(String[] args) {

        //  create instance of api service using retrofit client
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        // to update

        User updateUser = new User();
        updateUser.setName("nasim surosh");
        updateUser.setEmail("nasim@gmail.com");

        Call<User> userCall = apiService.updateUser(1, updateUser);

        // asynchronously enqueue the http request and define call back for success and failure
        userCall.enqueue(new Callback<User>() {

            @Override
            // this callback method is called when we have successful http request
            public void onResponse(Call<User> call, Response<User> response) {
                // check if response is successful(HTTP status code 2XX)
                if (response.isSuccessful()) {
                    // Extract user object from response body
                    User user = response.body();
                    System.out.println("Updated user with id: "+user.getId());
                    System.out.println("User name: "+user.getName());
                    System.out.println("User email: "+user.getEmail());
                    System.out.println("User updated succesfully");
                }else{
                    System.out.println("Failed to create user");
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

