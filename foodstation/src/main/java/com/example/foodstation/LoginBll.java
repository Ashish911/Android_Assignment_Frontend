package com.example.foodstation;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {

    boolean isSuccess = false;

    public boolean checkUser(String Email, String Password) {

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(Email, Password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful()){
                Url.token += loginResponse.body().getToken();
                Url.userid=loginResponse.body().getUserid();
                isSuccess = true;
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
