package com.example.onlinefoodportal.api;

import com.example.onlinefoodportal.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OrderAPI {

    @POST("order")
    Call<Void> order(@Header("Authorization") String token, @Body Order order);

    @GET("order")
    Call<List<Order>> getOrder(@Header("Authorization") String token);

}
