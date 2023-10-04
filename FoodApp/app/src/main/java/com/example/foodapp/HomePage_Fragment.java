package com.example.foodapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;




public class HomePage_Fragment extends Fragment {



    public HomePage_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("thanhtung","Fragment home");
    }

    //load lại dữ liệu fragment
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_page_, container, false);

        SearchView sv_foods = view.findViewById(R.id.sv_foods);
        sv_foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv_foods.setIconified(false);
            }
        });

        return view;
    }


}