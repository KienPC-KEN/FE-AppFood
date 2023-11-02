package com.example.foodapp.Adapter_Customer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.Category;
import com.example.foodapp.databinding.ItemCategoryBinding;

import java.util.ArrayList;

public class Menu_CategoryAdapter extends RecyclerView.Adapter<Menu_CategoryAdapter.Holder> {

    private ArrayList<Category> list;

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
