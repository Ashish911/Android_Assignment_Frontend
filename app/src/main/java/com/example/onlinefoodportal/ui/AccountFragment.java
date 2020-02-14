package com.example.onlinefoodportal.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodportal.MainActivity;
import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.api.UsersAPI;
import com.example.onlinefoodportal.bll.LogoutBll;
import com.example.onlinefoodportal.model.Users;
import com.example.onlinefoodportal.strictmode.StrictModeClass;
import com.example.onlinefoodportal.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private Button btnLogOut;
    TextView Username, PhoneNo;
    RelativeLayout relativeLayout, relativeLayoutprofile;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        relativeLayout = view.findViewById(R.id.relativelayoutOut);
        relativeLayoutprofile = view.findViewById(R.id.profilelayout);
        Username = view.findViewById(R.id.username);
        PhoneNo = view.findViewById(R.id.PhoneNoP);
        btnLogOut = view.findViewById(R.id.Logout);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        final Call<Users> usersCall = usersAPI.getUserDetails(Url.token);

        usersCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()){
                    Username.setText(response.body().getUserName());
                    PhoneNo.setText(response.body().getPhoneNo());
                    return;
                }
                else {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void logout(){
        String token= Url.token;

        LogoutBll logoutBLL = new LogoutBll();
        StrictModeClass.StrictMode();
        if (logoutBLL.logout(token)){
            getActivity().finish();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(getActivity(), "Logout succecsful", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getContext(), "Logout process failed! Please try again", Toast.LENGTH_SHORT).show();
        }
    }

}
