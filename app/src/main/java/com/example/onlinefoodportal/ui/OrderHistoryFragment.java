package com.example.onlinefoodportal.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.SearchActivity;
import com.example.onlinefoodportal.adapter.OrderAdapter;
import com.example.onlinefoodportal.api.OrderAPI;
import com.example.onlinefoodportal.model.Order;
import com.example.onlinefoodportal.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderHistoryFragment extends Fragment {

    ImageView Search;
    RecyclerView recyclerView;

    public OrderHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orderhistory, container, false);
        recyclerView = view.findViewById(R.id.OrderRecylceView);

        Search = view.findViewById(R.id.searchfood);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        OrderAPI orderAPI = Url.getInstance().create(OrderAPI.class);
        Call<List<Order>> listCall = orderAPI.getOrder(Url.token);
        listCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.code()==200){
                    Toast.makeText(getActivity(), "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }
                OrderAdapter orderAdapter = new OrderAdapter(getActivity(),response.body());
                recyclerView.setAdapter(orderAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                orderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
