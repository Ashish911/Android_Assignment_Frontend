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

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryAdapterViewHolder>{

    private Context mcontext;
    private List<Category> categories;

    public CategoryAdapter(Context mcontext, List<Category> categories) {
        this.mcontext = mcontext;
        this.categories = categories;
    }

    @NonNull
    @Override
    public categoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_category,null);
        return new categoryAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapterViewHolder holder, int position) {

        final Category category=categories.get(position);
        holder.categoryImg.setImageResource(category.getCategoryImg());
        holder.categoryName.setText(category.getCategoryName());


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class categoryAdapterViewHolder extends RecyclerView.ViewHolder{

        private ImageView categoryImg;
        private TextView categoryName;
        public categoryAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryImg=itemView.findViewById(R.id.imgCategory);
            this.categoryName=itemView.findViewById(R.id.tvCName);
        }

        private void setCategoryImg(){

        }

        private void setCategory(String name){
            categoryName.setText(name);

        }
    }
}
