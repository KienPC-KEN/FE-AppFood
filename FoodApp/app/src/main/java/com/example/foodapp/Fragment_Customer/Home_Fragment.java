package com.example.foodapp.Fragment_Customer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.Add_Food_Acivity;
import com.example.foodapp.Chat_Activity;
import com.example.foodapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {

    RecyclerView recyclerViewFoods, recyclerViewDrinks;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_customer, container, false);

        SearchView sv_foods = view.findViewById(R.id.sv_foods);
        sv_foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv_foods.setIconified(false);
            }
        });

        ImageView imgphone = view.findViewById(R.id.img_phone);
        imgphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Chat_Activity.class); // Thay TargetActivity bằng tên của Activity mục tiêu
                startActivity(intent);
            }
        });



        return view;
    }


}