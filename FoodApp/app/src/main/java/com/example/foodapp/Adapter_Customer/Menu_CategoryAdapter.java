package com.example.foodapp.Adapter_Customer;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.Category;
import com.example.foodapp.Model.Product;
import com.example.foodapp.Util.CategoryCallBack;
import com.example.foodapp.databinding.ItemCategoryBinding;

import java.util.ArrayList;
import java.util.List;

public class Menu_CategoryAdapter extends RecyclerView.Adapter<Menu_CategoryAdapter.Holder> {

    public ArrayList<Category> list;
    public ArrayList<Product> productList;
    private int selectedPos = -1;

    public Menu_CategoryAdapter(ArrayList<Category> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindData(list.get(position));
        holder.binding.tvCategoryName.setOnClickListener(v -> {
            selectedPos = holder.getAdapterPosition();
            holder.binding.tvCategoryName.setTypeface(null, Typeface.BOLD);
            notifyDataSetChanged();
        });
        if (selectedPos != position) {
            holder.binding.tvCategoryName.setTypeface(Typeface.DEFAULT);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setData(List<Category> newList) {
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new CategoryCallBack(this.list, newList));
        this.list.clear();
        this.list.addAll(newList);
        result.dispatchUpdatesTo(this);
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
