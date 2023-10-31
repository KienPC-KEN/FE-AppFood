package com.example.foodapp.Fragment_Customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.foodapp.Adapter_Customer.HomeAdapter;
import com.example.foodapp.Model.Product;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentHomeCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {
    private static final String TAG = "Home_Fragment";
    private FragmentHomeCustomerBinding binding;
    private ArrayList<Product> list;
    private HomeAdapter adapter;

    //load lại dữ liệu fragment
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeCustomerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();

        JsonArrayRequest getProduct = new JsonArrayRequest(Request.Method.GET, Config.IP + "product", null,
                response -> {
                    list = new Gson().fromJson(response.toString(), new TypeToken<ArrayList<Product>>() {
                    }.getType());
                    adapter = new HomeAdapter(list);
                    binding.recyclerViewDrinks.setAdapter(adapter);
                    binding.recyclerViewFoods.setAdapter(adapter);
                }
                , error -> {
                    Toast.makeText(getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
        });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(getProduct);

    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}