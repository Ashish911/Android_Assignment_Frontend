package com.example.onlinefoodportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodportal.adapter.SearchAdapter;
import com.example.onlinefoodportal.api.FoodAPI;
import com.example.onlinefoodportal.model.Food;
import com.example.onlinefoodportal.ui.HomeFragment;
import com.example.onlinefoodportal.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    ImageButton Back, Search;
    TextView etSearch;
    RecyclerView recyclerView;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Back = findViewById(R.id.backS);
        Search = findViewById(R.id.searchS);
        etSearch = findViewById(R.id.etsearch);
        recyclerView = findViewById(R.id.recyclerViewSearch);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FoodAPI foodAPI = Url.getInstance().create(FoodAPI.class);

                Call<List<Food>>listCall = foodAPI.searchFood(etSearch.getText().toString());

                listCall.enqueue(new Callback<List<Food>>() {
                    @Override
                    public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText(SearchActivity.this, "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                        }

                        SearchAdapter searchAdapter = new SearchAdapter(SearchActivity.this, response.body());
                        recyclerView.setAdapter(searchAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                        searchAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Food>> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
