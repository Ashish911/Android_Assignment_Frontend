package com.example.onlinefoodportal.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.adapter.FavouriteAdapter;
import com.example.onlinefoodportal.api.FavouriteAPI;
import com.example.onlinefoodportal.model.Favourite;
import com.example.onlinefoodportal.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment {

    RecyclerView recyclerView;

    public FavouritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_favourites, container, false);
        recyclerView = root.findViewById(R.id.favouriterecyclerview);
        getFood();
        return root;
    }

    public void getFood(){
        FavouriteAPI favouriteAPI = Url.getInstance().create(FavouriteAPI.class);
        Call<List<Favourite>> listCall = favouriteAPI.getFavorite(Url.token);
        listCall.enqueue(new Callback<List<Favourite>>() {
            @Override
            public void onResponse(Call<List<Favourite>> call, Response<List<Favourite>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                FavouriteAdapter favouriteAdapter = new FavouriteAdapter(getActivity(), response.body());
                recyclerView.setAdapter(favouriteAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                favouriteAdapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<List<Favourite>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
