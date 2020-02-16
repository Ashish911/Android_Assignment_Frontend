package com.example.onlinefoodportal.bll;

import com.example.onlinefoodportal.api.UsersAPI;
import com.example.onlinefoodportal.model.Users;
import com.example.onlinefoodportal.serverresponse.SignUpResponse;
import com.example.onlinefoodportal.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class SignUpBll {

    boolean isSuccess = false;
    public boolean Useradd(Users user) {
        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.registerUser(user);
        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful()) {
                Url.token += loginResponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}
