package com.example.foodapp.Fragment_Customer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.foodapp.Adapter_Customer.Customer_HomeAdapter;
import com.example.foodapp.Model.Product;
import com.example.foodapp.R;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentHomeCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class Home_Fragment extends Fragment {
    private static final String TAG = "Home_Fragment";
    private FragmentHomeCustomerBinding binding;
    private ArrayList<Product> list;
    private Customer_HomeAdapter adapter;

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
                    adapter = new Customer_HomeAdapter(list);
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