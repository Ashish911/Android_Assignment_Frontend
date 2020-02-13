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
import com.example.onlinefoodportal.model.Category;
import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>{

    private List<Category> categoryList;
    private Context context;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_category,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Category category = categoryList.get(position);
        Picasso.get().load(Url.base_url_image + categoryList.get(position).getCategoryImage()).into(holder.imgcategory);
        holder.tvCName.setText(category.getCategoryName());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgcategory;
        private TextView tvCName;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgcategory = itemView.findViewById(R.id.imgCategory);
            tvCName = itemView.findViewById(R.id.tvCName);
        }
    }

}
