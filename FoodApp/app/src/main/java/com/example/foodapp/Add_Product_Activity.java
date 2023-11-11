package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.example.foodapp.Model.Category;
import com.example.foodapp.adapter_staff.CategoryDropDownAdapter;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.ActivityAddProductBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Add_Product_Activity extends AppCompatActivity {

    private static final String TAG = "Add_Product_Activity";
    private ActivityAddProductBinding binding;
    private ArrayList<Category> categoryData;
    private ArrayList<Category> newCategoryData;
    private CategoryDropDownAdapter dropDownAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        categoryData = new ArrayList<>();

        binding.imgBack.setOnClickListener(v -> Add_Product_Activity.super.finish());

        getCategory(intent.getStringExtra("category_type"));

    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    public void getCategory(String type) {
        VolleySingleton.getInstance(this).addToRequestQueue(new StringRequest(Config.IP + "category", response -> {
            categoryData = new Gson().fromJson(response, new TypeToken<ArrayList<Category>>() {
            }.getType());
            newCategoryData = new ArrayList<>();
            for (Category c :
                    categoryData) {
                if (c.getType().equals(type)) {
                    newCategoryData.add(c);
                }
            }
            dropDownAdapter = new CategoryDropDownAdapter(this, newCategoryData);
            binding.categoryDropdown.setAdapter(dropDownAdapter);
        }, error -> {
            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
        }));
    }
}