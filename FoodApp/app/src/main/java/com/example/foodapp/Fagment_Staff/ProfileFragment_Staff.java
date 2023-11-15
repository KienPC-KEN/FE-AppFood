package com.example.foodapp.Fagment_Staff;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;

public class ProfileFragment_Staff extends Fragment {
    private ImageView imgBack, imgAVT;
    private TextView txtName, txtPhone, txtDate, txtSex, txtEmail, txtAddress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_staff, container, false);
        imgBack = view.findViewById(R.id.back);
        imgAVT = view.findViewById(R.id.imgAvt);

        txtName = view.findViewById(R.id.nameStaff);
        txtPhone = view.findViewById(R.id.phoneStaff);
        txtDate = view.findViewById(R.id.dateStaff);
        txtSex = view.findViewById(R.id.sexStaff);
        txtEmail = view.findViewById(R.id.emailStaff);
        txtAddress = view.findViewById(R.id.addressStaff);

        getDataUserStaff();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                MoreFragment_Staff moreFragmentStaff = new MoreFragment_Staff();
                transaction.replace(R.id.frameLayout, moreFragmentStaff);
                transaction.commit();
            }
        });
        return view;
    }

    private void getDataUserStaff() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("profile", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String phone = sharedPreferences.getString("phone", "");
        String date = sharedPreferences.getString("date", "");
        String sex = sharedPreferences.getString("sex", "");
        String email = sharedPreferences.getString("email", "");
        String address = sharedPreferences.getString("address", "");
        String image = sharedPreferences.getString("image", "");

        txtName.setText(name);
        txtPhone.setText(phone);
        txtDate.setText(date);
        txtSex.setText(sex);
        txtEmail.setText(email);
        txtAddress.setText(address);

        Glide.with(getActivity()).load(image).centerCrop().into(imgAVT);
    }
}
