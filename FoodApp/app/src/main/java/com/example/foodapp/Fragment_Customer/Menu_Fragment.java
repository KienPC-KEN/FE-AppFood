package com.example.foodapp.Fragment_Customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.widget.ViewPager2;

import com.example.foodapp.Adapter_Customer.ViewPagerMenuAdapter;
import com.example.foodapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Menu_Fragment extends Fragment {
   private TabLayout tabLayout;
   private ViewPager2 viewPager2;
   ViewPagerMenuAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_customer, container, false);
        SearchView sv_foods = view.findViewById(R.id.sv_foods);



        viewPager2 = view.findViewById(R.id.paperMenu);
        tabLayout = view.findViewById(R.id.tabMenu);

        adapter = new ViewPagerMenuAdapter(requireActivity());
        viewPager2.setAdapter(adapter);

        viewPager2.setUserInputEnabled(false);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Foods");
                    break;
                case 1:
                    tab.setText("Drink");
                    break;
            }
        }).attach();

        return view;
    }
}