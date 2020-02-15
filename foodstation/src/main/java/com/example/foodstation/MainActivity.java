package com.example.foodstation;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodstation.strictmode.StrictModeClass;

public class MainActivity extends WearableActivity {

    EditText etEmail, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etWearEmail);
        etPassword = findViewById(R.id.etWearPassword);
        btnLogin = findViewById(R.id.btnWearLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }

    private void login(){
        if(TextUtils.isEmpty(etEmail.getText())){
            etEmail.setError("Enter Email");
        }
        else if(TextUtils.isEmpty(etPassword.getText())){
            etPassword.setError("Enter Password");
        }
        String Email = String.valueOf(etEmail.getText());
        String Password = String.valueOf(etPassword.getText());

        LoginBll loginBll = new LoginBll();

        StrictModeClass.StrictMode();
        if (loginBll.checkUser(Email, Password)) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
        }
    }
}
