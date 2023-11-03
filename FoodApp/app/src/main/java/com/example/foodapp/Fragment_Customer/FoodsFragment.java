package com.example.foodapp.Fragment_Customer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.example.foodapp.Adapter_Customer.Menu_CategoryAdapter;
import com.example.foodapp.Model.Category;
import com.example.foodapp.R;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentFoodsCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FoodsFragment extends Fragment {
    private static final String TAG = "Food_Fragment";
    private FragmentFoodsCustomerBinding binding;
    private ArrayList<Category> list;
    private Menu_CategoryAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodsCustomerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();

        StringRequest getCategory = new StringRequest(Config.IP + "category", response -> {
            list = new Gson().fromJson(response, new TypeToken<ArrayList<Category>>() {
            }.getType());
            ArrayList<Category> listDrink = new ArrayList<>();
            for (Category category :
                    list) {
                if (category.getType().equals("food")) {
                    listDrink.add(category);
                }
            }
            adapter = new Menu_CategoryAdapter(listDrink);
            binding.rcvFoodCategoryMenu.setAdapter(adapter);
        }, error -> {
            Toast.makeText(getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
        });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(getCategory);

    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}