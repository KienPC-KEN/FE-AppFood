package com.example.foodapp.adapter_staff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ItemHomeStaffBinding;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new HomeViewHolder(ItemHomeStaffBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false))  ;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int position) {
        holder.binding.phoneCustomer.setText("HEHEHE");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private ItemHomeStaffBinding binding;
        public HomeViewHolder(@NonNull ItemHomeStaffBinding binding) {
            super(binding.getRoot());
        }
    }
}
