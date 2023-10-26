package com.example.foodapp.Fagment_Staff;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.Add_Drink_Acivity;
import com.example.foodapp.R;
import com.example.foodapp.Remove_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Drinks_Staff_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drinks__staff_, container, false);

        AppCompatButton btnaddnewdrink = view.findViewById(R.id.btn_adddrink);
        AppCompatButton btnremovedrink = view.findViewById(R.id.btn_removedrink);


        btnremovedrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Remove_Activity.class); // Thay TargetActivity bằng tên của Activity mục tiêu
                startActivity(intent);

            }

        });


        btnaddnewdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Add_Drink_Acivity.class); // Thay TargetActivity bằng tên của Activity mục tiêu
                    startActivity(intent);

            }

        });

        return view;
    }
}