package com.example.onlinefoodportal.bll;

import com.example.onlinefoodportal.api.UsersAPI;
import com.example.onlinefoodportal.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LogoutBll {

    boolean isSuccess=false;

    public boolean logout(String token){
        UsersAPI usersApi= Url.getInstance().create(UsersAPI.class);
        Call<Void> voidCall=usersApi.logOut(token);
        try {
            Response<Void> response= voidCall.execute();
            if (response.code()==200){
                Url.token=("Bearer ");
                isSuccess=true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
