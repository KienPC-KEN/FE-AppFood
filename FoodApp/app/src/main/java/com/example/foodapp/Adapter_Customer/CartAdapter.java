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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Map<String, String>> cartData;
    private Context context;

    public CartAdapter(ArrayList<Map<String, String>> cartData, Context context) {
        this.cartData = cartData;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Map<String, String> cartItem = cartData.get(position);

        String productName = cartItem.get("productName");
        String productPrice = cartItem.get("productPrice");
        String productQuantity = cartItem.get("productQuantity");
        String total = cartItem.get("productTotal");

        holder.productName.setText(productName);
        holder.productPrice.setText(productPrice);
        holder.productQuantity.setText(productQuantity);
        holder.productTotal.setText(total);

    }

    @Override
    public int getItemCount() {
        if (cartData != null) {

            return cartData.size();
        } else {

            return 0;
        }

    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice, productQuantity, productTotal;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tvProduct);
            productPrice = itemView.findViewById(R.id.priceProduct);
            productQuantity = itemView.findViewById(R.id.quantityProduct);
            productTotal = itemView.findViewById(R.id.totalPriceProduct);
        }
    }
}
