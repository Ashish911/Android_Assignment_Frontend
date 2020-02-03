package com.example.onlinefoodportal.ui;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.adapter.CategoryAdapter;
import com.example.onlinefoodportal.adapter.SliderAdapter;
import com.example.onlinefoodportal.model.Category;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    SliderView sliderView;
    RecyclerView recyclerView;
    ImageView categoryImg;

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

        final SliderAdapter adapter = new SliderAdapter(getContext());
        adapter.setCount(3);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category(R.drawable.restaurant,"Restaurants"));
        categoryList.add(new Category(R.drawable.liquor,"Liquors"));
        categoryList.add(new Category(R.drawable.bakeries,"Bakeries"));
        categoryList.add(new Category(R.drawable.icecream, "Refreshments"));
        categoryList.add(new Category(R.drawable.organic,"Organic"));

        final CategoryAdapter categoryAdapter=new CategoryAdapter(getContext(),categoryList);
        recyclerView.setAdapter(categoryAdapter);

        return view;
    }

}
