package com.example.onlinefoodportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

public class FoodDisplayActivity extends AppCompatActivity {

    Toolbar toolbar;
    private TextView tvName, tvPrice;
    private ImageView imgFood;
    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_display);

        toolbar = findViewById(R.id.toolBarF);
        setSupportActionBar(toolbar);

        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        imgFood = findViewById(R.id.imgfood);

        Intent intent = getIntent();
        final String Name = intent.getExtras().getString("Name");
        final int Price = intent.getExtras().getInt("Price");
        final String img = intent.getExtras().getString("Image");
        final String Id = intent.getExtras().getString("id");

        tvName.setText(Name);
        tvPrice.setText("Rs " + Price);
        Picasso.get().load(Url.base_url_image + img).into(imgFood);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.Home:
                intent = new Intent(this, DashboardActivity.class);
                intent.putExtra("name", "home");
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
