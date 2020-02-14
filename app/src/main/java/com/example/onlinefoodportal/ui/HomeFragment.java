package com.example.onlinefoodportal.ui;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onlinefoodportal.MainActivity;
import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.SearchActivity;
import com.example.onlinefoodportal.SignUpActivity;
import com.example.onlinefoodportal.adapter.CategoryAdapter;
import com.example.onlinefoodportal.adapter.FoodAdapter;
import com.example.onlinefoodportal.adapter.HomeFoodAdapter;
import com.example.onlinefoodportal.adapter.SliderAdapter;
import com.example.onlinefoodportal.api.CategoryAPI;
import com.example.onlinefoodportal.api.FoodAPI;
import com.example.onlinefoodportal.model.Category;
import com.example.onlinefoodportal.model.Food;
import com.example.onlinefoodportal.url.Url;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    SliderView sliderView;
    RecyclerView recyclerView,foodrecyclerview;
    ImageView categoryImg;
    ImageButton Search;

    public HomeFragment() {
        // Required empty public constructor
    }

 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.categoryRecyclerView);
        categoryImg=view.findViewById(R.id.imgCategory);
        sliderView = view.findViewById(R.id.Slider);
        Search = view.findViewById(R.id.searchrestaurant);
        foodrecyclerview = view.findViewById(R.id.FoodsRecycleView);

        final SliderAdapter adapter = new SliderAdapter(getContext());
        adapter.setCount(3);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        getCategory();
        getFoods();
        return view;
    }

    private void getCategory(){
        CategoryAPI categoryAPI = Url.getInstance().create(CategoryAPI.class);
        Call<List<Category>> listCall = categoryAPI.getCategory();
        listCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }
                CategoryAdapter categoryAdapter = new CategoryAdapter(response.body(), getActivity());
                recyclerView.setAdapter(categoryAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFoods(){
        FoodAPI foodAPI = Url.getInstance().create(FoodAPI.class);
        Call<List<Food>> listCall = foodAPI.getFood();
        listCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }

                HomeFoodAdapter homeFoodAdapter = new HomeFoodAdapter(response.body(),getActivity());
                foodrecyclerview.setAdapter(homeFoodAdapter);
                foodrecyclerview.setHasFixedSize(true);
                foodrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
                homeFoodAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });
    }

}
