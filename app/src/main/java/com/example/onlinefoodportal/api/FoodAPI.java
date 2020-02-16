package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodAPI {

    @GET("food/")
    Call<List<Food>> getFood();

    @GET("food/search/{foodName}")
    Call<List<Food>> searchFood(@Path("foodName") String FoodName);

    @GET("food/getByRestaurant/{id}")
    Call<List<Food>> getRestaurantByID(@Path("id") String Restaurantid);

}
