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
                    Intent intent = new Intent(Splash_Screen_Activity.this,IntroActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
    }
}
