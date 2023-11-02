package com.example.foodapp.Adapter_Customer;

import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.Category;
import com.example.foodapp.Model.Product;
import com.example.foodapp.databinding.ItemCategoryBinding;

import java.util.ArrayList;

public class Menu_CategoryAdapter extends RecyclerView.Adapter<Menu_CategoryAdapter.Holder> {

    private final ArrayList<Category> list;

    public Menu_CategoryAdapter(ArrayList<Category> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindData(list.get(position));
        holder.binding.tvCategoryName.setOnClickListener(v -> {
            if(holder.binding.tvCategoryName.getTypeface() == Typeface.DEFAULT) {
                holder.binding.tvCategoryName.setTypeface(null, Typeface.BOLD);
            }else {
                holder.binding.tvCategoryName.setTypeface(Typeface.DEFAULT);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ItemCategoryBinding binding;

        public Holder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(Category category) {
            binding.tvCategoryName.setText(category.getName());
        }
    }
}
