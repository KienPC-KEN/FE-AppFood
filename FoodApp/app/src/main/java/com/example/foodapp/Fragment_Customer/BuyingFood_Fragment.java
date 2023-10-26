package com.example.foodapp.Fragment_Customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.foodapp.R;

public class BuyingFood_Fragment extends Fragment {
    private TextView tvQuantity;
    private int quantity = 1; // Số lượng mặc định
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.buying_food_fragment, container, false);

        tvQuantity = view.findViewById(R.id.tvQuantity);
        return view;
    }
    // Phương thức xử lý khi nút tăng được nhấn
    public void increaseQuantity(View view) {
        quantity++;
        updateQuantity();
    }

    // Phương thức xử lý khi nút giảm được nhấn
    public void decreaseQuantity(View view) {
        if (quantity > 1) {
            quantity--;
            updateQuantity();
        }
    }

    // Cập nhật hiển thị số lượng
    private void updateQuantity() {
        tvQuantity.setText(String.valueOf(quantity));
    }
}
