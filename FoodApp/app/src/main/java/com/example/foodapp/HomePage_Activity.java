package com.example.foodapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.foodapp.Fragment.History_Fragment;
import com.example.foodapp.Fragment.HomePage_Fragment;
import com.example.foodapp.Fragment.Menu_Fragment;
import com.example.foodapp.Fragment.More_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class HomePage_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameLayout, new HomePage_Fragment()).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        fm.beginTransaction().replace(R.id.frameLayout, new HomePage_Fragment()).commit();
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