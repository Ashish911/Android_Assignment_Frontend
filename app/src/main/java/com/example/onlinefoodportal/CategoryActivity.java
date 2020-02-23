package com.example.onlinefoodportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onlinefoodportal.adapter.RestaurantAdapter;
import com.example.onlinefoodportal.api.RestaurantAPI;
import com.example.onlinefoodportal.model.Restaurant;
import com.example.onlinefoodportal.ui.HomeFragment;
import com.example.onlinefoodportal.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    ImageButton Back;
    RecyclerView recyclerView;
    ImageView itemImage;
    String categoryid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.RestaurantRecycleView);
        itemImage = findViewById(R.id.restaurantLogo);
        Back = findViewById(R.id.backF);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, HomeFragment.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            categoryid = bundle.getString("categoryid");
        }

        RestaurantAPI restaurantAPI = Url.getInstance().create(RestaurantAPI.class);
        Call<List<Restaurant>> listCall = restaurantAPI.getRestaurantByID(categoryid);
        listCall.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                RestaurantAdapter restaurantAdapter = new RestaurantAdapter(response.body(), CategoryActivity.this);
                recyclerView.setAdapter(restaurantAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(CategoryActivity.this, 1));
                restaurantAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
