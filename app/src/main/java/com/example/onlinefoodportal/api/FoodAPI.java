package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodAPI {

    @GET("food/")
    Call<List<Food>> getFood();

}
