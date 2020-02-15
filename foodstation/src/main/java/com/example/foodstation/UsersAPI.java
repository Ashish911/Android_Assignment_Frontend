package com.example.foodstation;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UsersAPI {

    @FormUrlEncoded
    @POST("user/login")
    Call<SignUpResponse> checkUser(@Field("Email") String Email, @Field("Password") String Password);

}
