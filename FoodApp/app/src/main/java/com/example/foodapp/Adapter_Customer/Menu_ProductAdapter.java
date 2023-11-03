package com.example.foodapp.Adapter_Customer;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.Product;
import com.example.foodapp.databinding.ItemProductMenuBinding;

import java.util.ArrayList;

public class Menu_ProductAdapter extends RecyclerView.Adapter<Menu_ProductAdapter.Holder> {

    public ArrayList<Product> list;

    public Menu_ProductAdapter(ArrayList<Product> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemProductMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static final class Holder extends RecyclerView.ViewHolder {
        ItemProductMenuBinding binding;

        public Holder(@NonNull ItemProductMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @SuppressLint("SetTextI18n")
        void bindData(Product product) {
            binding.tvName.setText(product.getName());
            binding.tvPrice.setText(product.getPrice().toString());
        }
    }
}
