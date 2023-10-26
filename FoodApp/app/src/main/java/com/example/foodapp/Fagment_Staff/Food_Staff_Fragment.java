package com.example.foodapp.Fagment_Staff;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.Add_Drink_Acivity;
import com.example.foodapp.Add_Food_Acivity;
import com.example.foodapp.R;
import com.example.foodapp.Remove_Activity;


public class Food_Staff_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food__staff_, container, false);

        AppCompatButton btnaddnewfood = view.findViewById(R.id.btn_addfood);
        AppCompatButton btnremovefood = view.findViewById(R.id.btn_removefood);


        btnremovefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Remove_Activity.class); // Thay TargetActivity bằng tên của Activity mục tiêu
                startActivity(intent);

            }

        });



        btnaddnewfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Add_Food_Acivity.class); // Thay TargetActivity bằng tên của Activity mục tiêu
                startActivity(intent);

            }

        });

        return view;
    }
    }
