package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantAPI {

    @GET("restaurant/")
    Call<List<Restaurant>> getRestaurant();

    @GET("restaurant/:id")
    Call<List<Restaurant>> getRestaurantById();

}
