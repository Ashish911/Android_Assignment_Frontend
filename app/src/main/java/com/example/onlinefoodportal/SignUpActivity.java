package com.example.onlinefoodportal;

import android.app.Notification;
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
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.onlinefoodportal.api.UsersAPI;
import com.example.onlinefoodportal.channel.CreateChannel;
import com.example.onlinefoodportal.model.Users;
import com.example.onlinefoodportal.serverresponse.SignUpResponse;
import com.example.onlinefoodportal.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;

    EditText etFullName, etUserName, etEmail, etPhoneNo, etPassword;
    ImageButton btnSignUp;
    Button btnLogin;
    CheckBox chkterms;
    int id=1;

    boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        etFullName = findViewById(R.id.FullNameSF);
        etUserName = findViewById(R.id.UserNameSF);
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
                if (TextUtils.isEmpty(etFullName.getText())) {
                    etFullName.setError("Enter FullName");
                    return;
                } else if (TextUtils.isEmpty(etUserName.getText())) {
                    etUserName.setError("Enter UserName");
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

                String FullName = etFullName.getText().toString();
                String UserName = etUserName.getText().toString();
                String Email = etEmail.getText().toString();
                String PhoneNo = etPhoneNo.getText().toString();
                String Password = etPassword.getText().toString();

                Users users = new Users(FullName, UserName, Email, PhoneNo, Password);

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
                        Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                DisplayNotification();
            }
        });

    }

    public void DisplayNotification() {

        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("Registered")
                .setContentText("Registered Successfully")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }
}
