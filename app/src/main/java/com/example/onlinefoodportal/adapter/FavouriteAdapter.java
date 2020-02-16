package com.example.onlinefoodportal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinefoodportal.DashboardActivity;
import com.example.onlinefoodportal.FoodDisplayActivity;
import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.api.FavouriteAPI;
import com.example.onlinefoodportal.model.Favourite;
import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteAPI favoriteApi=Url.getInstance().create(FavouriteAPI.class);
                Call<Void> voidCall=favoriteApi.removeFavorite(favouriteList.get(position).getId());
                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(context, "You have remove a favorite book", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, DashboardActivity.class);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(context, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
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
        private ImageButton imgRemove;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.FPic);
            tvName = itemView.findViewById(R.id.FName);
            tvPrice = itemView.findViewById(R.id.FPrice);
            tvId = itemView.findViewById(R.id.FID);
            imgRemove = itemView.findViewById(R.id.imgRemove);
        }
    }
}
