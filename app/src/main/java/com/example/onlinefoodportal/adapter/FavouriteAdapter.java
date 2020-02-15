package com.example.onlinefoodportal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinefoodportal.FoodDisplayActivity;
import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.model.Favourite;
import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ItemViewHolder> {

    private Context context;
    private List<Favourite> favouriteList;


    public FavouriteAdapter(Context context, List<Favourite> favouriteList) {
        this.context = context;
        this.favouriteList = favouriteList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_favourites, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

        final Favourite favourite = favouriteList.get(position);
        Picasso.get().load(Url.base_url_image + favouriteList.get(position).getFood().getFoodImage()).into(holder.imgFood);
        holder.tvId.setText(favourite.getFood().get_id());
        holder.tvName.setText(favourite.getFood().getFoodName());
        holder.tvPrice.setText(favourite.getFood().getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDisplayActivity.class);
                intent.putExtra("id", favouriteList.get(position).getFood().get_id());
                intent.putExtra("Name", favouriteList.get(position).getFood().getFoodName());
                intent.putExtra("Price", favouriteList.get(position).getFood().getPrice());
                intent.putExtra("Image", favouriteList.get(position).getFood().getFoodImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFood;
        private TextView tvName, tvPrice, tvId;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.FPic);
            tvName = itemView.findViewById(R.id.FName);
            tvPrice = itemView.findViewById(R.id.FPrice);
            tvId = itemView.findViewById(R.id.FID);
        }
    }
}
