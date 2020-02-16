package com.example.onlinefoodportal.bll;

import com.example.onlinefoodportal.api.OrderAPI;
import com.example.onlinefoodportal.model.Order;
import com.example.onlinefoodportal.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class OrderBll {
    boolean isSuccess = false;
    public boolean orderadd(Order order) {
        OrderAPI orderApi = Url.getInstance().create(OrderAPI.class);
        Call<Void> voidCall = orderApi.order(Url.token,order);
        try {
            Response<Void> voidResponse = voidCall.execute();
            if (voidResponse.isSuccessful()) {
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
