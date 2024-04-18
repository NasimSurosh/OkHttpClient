package com.example.HttpClient.Http_Client.Retrofit;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    // make a get request
    @GET("users/{userId}")
    Call<User> getUserById(@Path("userId") int userId);

    @POST("users/")
    Call<User> createUser(@Body User user);

    @PUT("users/{userId}")
    Call<User> updateUser(@Path("userId") int userId, @Body User user);

    @DELETE("users/{userId}")
    Call<User> deleteUser(@Path("userId") int userId);
}
