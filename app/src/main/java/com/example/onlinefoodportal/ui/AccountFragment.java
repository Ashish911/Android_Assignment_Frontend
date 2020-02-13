package com.example.onlinefoodportal.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlinefoodportal.MainActivity;
import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.bll.LogoutBll;
import com.example.onlinefoodportal.strictmode.StrictModeClass;
import com.example.onlinefoodportal.url.Url;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private Button btnLogOut;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        btnLogOut = view.findViewById(R.id.Logout);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
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
