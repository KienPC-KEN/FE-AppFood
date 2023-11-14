package com.example.foodapp.Fagment_Staff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.example.foodapp.Model.Category;
import com.example.foodapp.adapter_staff.StaffCategoryAdapter;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentStaffCategoryBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class StaffCategoryFragment extends Fragment {
    private FragmentStaffCategoryBinding binding;
    private ArrayList<Category> categoryData;
    private StaffCategoryAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentStaffCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryData = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        binding.rcvStaffCategory.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
        binding.rcvStaffCategory.addItemDecoration(itemDecoration);

        getCategory();
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    public void getCategory() {
        VolleySingleton.getInstance(getContext()).addToRequestQueue(new StringRequest(Config.IP + "category", response -> {
            categoryData = new Gson().fromJson(response, new TypeToken<ArrayList<Category>>() {
            }.getType());
            adapter = new StaffCategoryAdapter(categoryData);
            binding.rcvStaffCategory.setAdapter(adapter);
        }, error -> {
            Toast.makeText(getContext(), "onFailure: " + error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
        }));
    }
}