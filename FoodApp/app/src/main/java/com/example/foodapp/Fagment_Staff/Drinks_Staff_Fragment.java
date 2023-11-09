package com.example.foodapp.Fagment_Staff;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.example.foodapp.Add_Drink_Acivity;
import com.example.foodapp.Model.Product;
import com.example.foodapp.R;
import com.example.foodapp.adapter_staff.S_Menu_ProductAdapter;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentDrinksStaffBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class Drinks_Staff_Fragment extends Fragment {
    private static final String TAG = "Staff_Drink_Fragment";
    private ArrayList<Product> productData;
    private S_Menu_ProductAdapter adapter;
    FragmentDrinksStaffBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDrinksStaffBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAddDrink.setOnClickListener(v -> startActivity(new Intent(getActivity(), Add_Drink_Acivity.class)));

        productData = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(requireActivity());
        binding.rcvDrinkProductMenu.setLayoutManager(manager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
        binding.rcvDrinkProductMenu.addItemDecoration(dividerItemDecoration);

        GETProduct();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.getRoot().requestLayout();
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    public void GETProduct() {
        StringRequest getProduct = new StringRequest(Config.IP + "Product", response -> {
            productData = new Gson().fromJson(response, new TypeToken<ArrayList<Product>>() {
            }.getType());
            ArrayList<Product> listFoodProduct = new ArrayList<>();
            for (Product p :
                    productData) {
                if (p.getCategory().getType().equals("drink")) {
                    listFoodProduct.add(p);
                }
            }
            adapter = new S_Menu_ProductAdapter(listFoodProduct);
            binding.rcvDrinkProductMenu.setAdapter(adapter);
        }, error -> {
            Toast.makeText(getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
        });

        VolleySingleton.getInstance(getContext()).addToRequestQueue(getProduct);
    }
}