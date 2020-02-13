package com.example.onlinefoodportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash_Screen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen_);

        Handler handler = new Handler();
        handler.postAtTime(new Runnable() {
                @Override
                public void run() {
//        checkemail();
                }
            }, 2000);
    }

//    private void checkemail(){
//        SharedPreferences sharedPreferences =getSharedPreferences("User",MODE_PRIVATE);
//        String email = sharedPreferences.getString("email", "");
//        String password = sharedPreferences.getString("email", "");
//
//        if (email.equals("Admin@admin.com")|| password.equals("Admin")){
//            Intent intent = new Intent(Splash_Screen_Activity.this,MainActivity.class);
//            startActivity(intent);
//            finish();
//            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Intent intent = new Intent(Splash_Screen_Activity.this,IntroActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }
}
