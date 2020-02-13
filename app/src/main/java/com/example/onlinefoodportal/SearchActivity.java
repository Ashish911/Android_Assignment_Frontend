package com.example.onlinefoodportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.onlinefoodportal.ui.HomeFragment;

public class SearchActivity extends AppCompatActivity {

    ImageButton Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Back = findViewById(R.id.backS);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, HomeFragment.class);
                startActivity(intent);
            }
        });
    }
}
