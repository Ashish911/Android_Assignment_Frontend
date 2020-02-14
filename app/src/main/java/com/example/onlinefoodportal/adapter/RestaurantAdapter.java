package com.example.onlinefoodportal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinefoodportal.FoodSectionActivity;
import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.model.Restaurant;
import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ItemViewHolder>{

    private List<Restaurant> restaurantList;
    private Context context;

    public RestaurantAdapter(List<Restaurant> restaurantList, Context context) {
        this.restaurantList = restaurantList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Restaurant restaurant = restaurantList.get(position);
        Picasso.get().load(Url.base_url_image + restaurantList.get(position).getLogo()).into(holder.imgrestaurant);
        holder.RestaurantName.setText(restaurant.getRestaurantName());
        holder.Location.setText(restaurant.getLocation());
        holder.Tags.setText(restaurant.getTags());
        holder.Delivery.setText(restaurant.getDelivery());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodSectionActivity.class);
                intent.putExtra("restaurantid", restaurant.get_id());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgrestaurant;
        private TextView RestaurantName;
        private TextView Location;
        private TextView Tags;
        private TextView Delivery;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgrestaurant = itemView.findViewById(R.id.restaurantLogo);
            RestaurantName = itemView.findViewById(R.id.RestaurantName);
            Location = itemView.findViewById(R.id.RestaurantLocation);
            Tags = itemView.findViewById(R.id.ResTag);
            Delivery = itemView.findViewById(R.id.ResDelivery);
        }
    }
}
