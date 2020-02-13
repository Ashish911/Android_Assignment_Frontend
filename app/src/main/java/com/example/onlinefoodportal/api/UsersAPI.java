package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Users;
import com.example.onlinefoodportal.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UsersAPI {

    @POST("user/signup")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("user/login")
    Call<SignUpResponse> checkUser(@Field("Email") String Email, @Field("Password") String Password);

    @POST("users/logout")
    Call<Void> logOut(@Header("Authorization") String token);
}
