package com.example.onlinefoodportal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinefoodportal.R;
import com.example.onlinefoodportal.model.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private Context context;
    private List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Order order = orderList.get(position);
        holder.tvFName.setText(order.getFoodname());
        holder.tvFPrice.setText("Rs " + order.getPrice());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFName,tvFPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFName = itemView.findViewById(R.id.tvfName);
            tvFPrice = itemView.findViewById(R.id.tvFPrice);
        }
    }
}
