package com.example.foodapp.Util;

import androidx.recyclerview.widget.DiffUtil;

import com.example.foodapp.Model.Product;

import java.util.List;
import java.util.Objects;

public class ProductCallback extends DiffUtil.Callback {

    private final List<Product> oldList;
    private final List<Product> newList;

    public ProductCallback(List<Product> oldList, List<Product> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return Objects.equals(oldList.get(oldItemPosition).getId(), newList.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition) == oldList.get(oldItemPosition);
    }
}
