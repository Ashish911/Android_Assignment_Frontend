package com.example.onlinefoodportal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.model.Food;
import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ItemViewHolder> {

    private List<Food> foodList;
    private Context context;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_foodsection, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Food food = foodList.get(position);
        Picasso.get().load(Url.base_url_image + foodList.get(position).getFoodImage()).into(holder.Image);
        holder.Name.setText(food.getFoodName());
        holder.Price.setText("Rs " + food.getPrice());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView Image;
        private TextView Name;
        private TextView Price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.FoodPic);
            Name = itemView.findViewById(R.id.FoodName);
            Price = itemView.findViewById(R.id.FoodPrice);
        }
    }
}
