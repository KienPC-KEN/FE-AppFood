package com.example.foodapp.adapter_staff;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Adapter_Customer.Menu_ProductAdapter;
import com.example.foodapp.Model.Category;
import com.example.foodapp.Model.Product;
import com.example.foodapp.Util.CategoryCallBack;
import com.example.foodapp.Util.ProductCallback;
import com.example.foodapp.databinding.ItemFoodMenuStaffBinding;
import com.example.foodapp.databinding.ItemProductMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class S_Menu_ProductAdapter extends RecyclerView.Adapter<S_Menu_ProductAdapter.Holder> {

    public ArrayList<Product> list;

    public S_Menu_ProductAdapter(ArrayList<Product> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new S_Menu_ProductAdapter.Holder(ItemFoodMenuStaffBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setData(List<Product> newList) {
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new ProductCallback(this.list, newList));
        this.list.clear();
        this.list.addAll(newList);
        result.dispatchUpdatesTo(this);
    }

    static final class Holder extends RecyclerView.ViewHolder {
        ItemFoodMenuStaffBinding binding;
        public Holder(@NonNull ItemFoodMenuStaffBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @SuppressLint("SetTextI18n")
        void bindData(Product product) {
            binding.tvFoodStaff.setText(product.getName());
            binding.tvPriceFoodStaff.setText(product.getPrice().toString());
        }
    }
}
