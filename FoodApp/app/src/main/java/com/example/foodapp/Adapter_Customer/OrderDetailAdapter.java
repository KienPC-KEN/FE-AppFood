package com.example.foodapp.Adapter_Customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Map;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {
    private ArrayList<Map<String, String>> orderDetails;
    private Context context;

    public OrderDetailAdapter(Context context, ArrayList<Map<String, String>> orderDetails) {
        this.orderDetails = orderDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Map<String, String> orderDetail = orderDetails.get(position);

        holder.orderItemTextView.setText(orderDetail.get("orderItem"));
        holder.countTextView.setText(orderDetail.get("count"));
        holder.priceTextView.setText(orderDetail.get("price"));
        holder.discountTextView.setText(orderDetail.get("discount"));
    }

    @Override
    public int getItemCount() {
        return orderDetails.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView orderItemTextView;
        public TextView countTextView;
        public TextView priceTextView;
        public TextView discountTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            orderItemTextView = itemView.findViewById(R.id.historyOrderName);
            countTextView = itemView.findViewById(R.id.historyOrderCount);
            priceTextView = itemView.findViewById(R.id.historyOrderPrice);
            discountTextView = itemView.findViewById(R.id.historyOrderDiscount);
        }
    }
}
