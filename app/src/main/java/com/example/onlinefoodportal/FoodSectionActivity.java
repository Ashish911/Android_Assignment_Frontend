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

import com.example.onlinefoodportal.adapter.FoodAdapter;
import com.example.onlinefoodportal.api.FoodAPI;
import com.example.onlinefoodportal.model.Food;
import com.example.onlinefoodportal.model.Restaurant;
import com.example.onlinefoodportal.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodSectionActivity extends AppCompatActivity {

    ImageButton Back;
    RecyclerView recyclerView;
    String restaurantid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_section);

        recyclerView = findViewById(R.id.FoodRecycleView);
        Back = findViewById(R.id.backF);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodSectionActivity.this, CategoryActivity.class);
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            restaurantid = bundle.getString("restaurantid");
        }

        FoodAPI foodAPI = Url.getInstance().create(FoodAPI.class);
        Call<List<Food>> listCall = foodAPI.getRestaurantByID(restaurantid);
        listCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (response.code()==200){
                    Toast.makeText(FoodSectionActivity.this, "Successfull" + response.code(), Toast.LENGTH_SHORT).show();
                }
                FoodAdapter foodAdapter = new FoodAdapter(response.body(), FoodSectionActivity.this);
                recyclerView.setAdapter(foodAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager( FoodSectionActivity.this, 1));
                foodAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Toast.makeText(FoodSectionActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
