package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestaurantAPI {

    @GET("restaurant/")
    Call<List<Restaurant>> getRestaurant();

    @GET("restaurant/:id")
    Call<List<Restaurant>> getRestaurantById();

    @GET("restaurant/getByCategory/{id}")
    Call<List<Restaurant>> getRestaurantByID(@Path("id") String Categoryid);

}
