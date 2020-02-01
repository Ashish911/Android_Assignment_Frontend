package com.example.onlinefoodportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinefoodportal.api.UsersAPI;
import com.example.onlinefoodportal.model.Users;
import com.example.onlinefoodportal.serverresponse.SignUpResponse;
import com.example.onlinefoodportal.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    EditText etFirstName, etLastName, etEmail, etPhoneNo, etPassword;
    ImageButton btnSignUp;
    Button btnLogin;
    CheckBox chkterms;

    boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etFirstName = findViewById(R.id.FirstNameSF);
        etLastName = findViewById(R.id.LastNameSF);
        etEmail = findViewById(R.id.emailSF);
        etPhoneNo = findViewById(R.id.PhoneNoSF);
        etPassword = findViewById(R.id.passwordSF);
        btnSignUp = findViewById(R.id.SignUpSF);
        btnLogin = findViewById(R.id.LoginSF);
        chkterms = findViewById(R.id.checkboxSF);

        chkterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked = true;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();

                String FirstName = etFirstName.getText().toString();
                String LastName = etLastName.getText().toString();
                String Email = etEmail.getText().toString();
                String PhoneNo = etPhoneNo.getText().toString();
                String Password = etPassword.getText().toString();

                Users users = new Users(FirstName, LastName, Email, PhoneNo, Password);

                UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
                Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);

                signUpCall.enqueue(new Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(SignUpActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this,DashboardActivity.class);
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void Validate(){
        if (TextUtils.isEmpty(etFirstName.getText())) {
            etFirstName.setError("Enter FirstName");
            return;
        } else if (TextUtils.isEmpty(etLastName.getText())) {
            etLastName.setError("Enter LastName");
            return;
        } else if (TextUtils.isEmpty(etEmail.getText())) {
            etEmail.setError("Enter Email-Address");
            return;
        } else if (TextUtils.isEmpty(etPhoneNo.getText())) {
            etPhoneNo.setError("Enter PhoneNo");
            return;
        } else if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Enter Password");
            return;
        } else if (isChecked == false) {
            chkterms.setError("Mandatory Field");
            return;
        }
    }
}
