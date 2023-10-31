package com.example.foodapp.Adapter_Customer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.Product;
import com.example.foodapp.databinding.ItemDrinkCustomerBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {
    private final ArrayList<Product> list;

    public HomeAdapter(ArrayList<Product> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemDrinkCustomerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ItemDrinkCustomerBinding binding;

        public Holder(@NonNull ItemDrinkCustomerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(Product product){
            Picasso.get().load(product.getImage()).into(binding.imgDrink);
            binding.tvNameDrink.setText(product.getName());
            binding.tvPriceDrink.setText(product.getPrice().toString());
        }
    }
}
