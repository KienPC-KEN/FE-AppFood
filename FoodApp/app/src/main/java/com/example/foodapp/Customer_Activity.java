package com.example.foodapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.foodapp.Fragment_Customer.History_Fragment;
import com.example.foodapp.Fragment_Customer.Home_Fragment;
import com.example.foodapp.Fragment_Customer.Menu_Fragment;
import com.example.foodapp.Fragment_Customer.More_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Customer_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameLayout, new Home_Fragment()).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        fm.beginTransaction().replace(R.id.frameLayout, new Home_Fragment()).commit();
                        return true;
                    case R.id.menu:
                        fm.beginTransaction().replace(R.id.frameLayout, new Menu_Fragment()).commit();
                        return true;
                    case R.id.history:
                        fm.beginTransaction().replace(R.id.frameLayout, new History_Fragment()).commit();
                        return true;
                    case R.id.more:
                        fm.beginTransaction().replace(R.id.frameLayout, new More_Fragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}