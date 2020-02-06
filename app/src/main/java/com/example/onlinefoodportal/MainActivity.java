package com.example.onlinefoodportal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.onlinefoodportal.bll.LoginBll;
import com.example.onlinefoodportal.strictmode.StrictModeClass;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText etUserName, etPassword;
    ImageButton btnLogin;
    Button btnSignUp;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarLF);

        etUserName = findViewById(R.id.UserNameLF);
        etPassword = findViewById(R.id.passwordLF);
        btnLogin = findViewById(R.id.signinLF);
        btnSignUp = findViewById(R.id.signupLF);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUserName.getText())) {
                    etUserName.setError("Enter UserName");
                    return;
                } else if (TextUtils.isEmpty(etPassword.getText())) {
                    etPassword.setError("Enter Password");
                    return;
                }

                String UserName = String.valueOf(etUserName.getText());
                String Password = String.valueOf(etPassword.getText());

                LoginBll loginBll = new LoginBll();

                StrictModeClass.StrictMode();
                if (loginBll.checkUser(UserName, Password)) {
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    etUserName.requestFocus();
                }
            }
        });
    }


//    private void SaveEmailPassword(){
//        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString("email", etPassword.getText().toString().trim());
//        editor.putString("password",etPassword.getText().toString().trim());
//        editor.commit();
//
//        Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
//    }
}
