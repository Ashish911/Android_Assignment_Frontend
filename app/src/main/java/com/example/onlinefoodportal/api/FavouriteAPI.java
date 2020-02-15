package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Favourite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface FavouriteAPI {

    @FormUrlEncoded
    @POST("favorite")
    Call<Void> addUser(@Header("Authorization") String token, @Field("foodid") String foodid);

    @GET("favorite")
    Call<List<Favourite>> getFavorite(@Header("Authorization") String token);
}
