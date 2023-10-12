package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;


import com.example.foodapp.Fagment_Staff.Menu_Fragment_Staff;
import com.example.foodapp.Fagment_Staff.More_Fragment_Staff;
import com.example.foodapp.Fagment_Staff.Oder_Fragment;
import com.example.foodapp.Fagment_Staff.Recipt_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_staff);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameLayout, new Oder_Fragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        fm.beginTransaction().replace(R.id.frameLayout, new Oder_Fragment()).commit();
                        return true;
                    case R.id.menu:
                        fm.beginTransaction().replace(R.id.frameLayout, new Menu_Fragment_Staff()).commit();
                        return true;
                    case R.id.history:
                        fm.beginTransaction().replace(R.id.frameLayout, new Recipt_Fragment()).commit();
                        return true;
                    case R.id.more:
                        fm.beginTransaction().replace(R.id.frameLayout, new More_Fragment_Staff()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}