package com.example.onlinefoodportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etEmail.getText())) {
                    etEmail.setError("Enter Email-Address");
                    return;
                } else if (TextUtils.isEmpty(etPassword.getText())) {
                    etPassword.setError("Enter Password");
                    return;
                }
                String Email, Password;
                Email = String.valueOf(etEmail.getText());
                Password = String.valueOf(etPassword.getText());
                if ((Email.equals("Admin@admin.com")) && (Password.equals("Admin"))) {
//                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
//                    startActivity(intent);
//                    SaveEmailPassword();
                } else {
                    Toast.makeText(MainActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SaveEmailPassword(){
        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("email", etPassword.getText().toString().trim());
        editor.putString("password",etPassword.getText().toString().trim());
        editor.commit();

        Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
    }
}
