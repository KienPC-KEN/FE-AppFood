package com.example.foodapp.Fragment_Customer;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.foodapp.Login.LoginActivity;
import com.example.foodapp.R;
import com.example.foodapp.config.Config;

import de.hdodenhof.circleimageview.CircleImageView;

public class More_Fragment extends Fragment {

    private TextView txtProfile, txtChangePass, txtLogout, tvName, tvEmail, tvPhone;

    private CircleImageView imgAvatar;
    private String IP = Config.IP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_customer, container, false);
        txtProfile = view.findViewById(R.id.txt_profile_more);
        txtChangePass = view.findViewById(R.id.txt_changePass);
        txtLogout = view.findViewById(R.id.txt_logout);
        tvName = view.findViewById(R.id.txt_name_more);
        tvEmail = view.findViewById(R.id.txt_email_more);
        tvPhone = view.findViewById(R.id.txt_sdt_more);
        imgAvatar = view.findViewById(R.id.avt_more);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String phone = sharedPreferences.getString("phone", "");
        String image = sharedPreferences.getString("image", "");
        String email = sharedPreferences.getString("email", "");

        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);

        Glide.with(getActivity()).load(image).into(imgAvatar);
        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Profile_Fragment profileFragment = new Profile_Fragment();
                transaction.add(R.id.frameLayout, profileFragment);
                transaction.commit();

            }
        });

        txtChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ChangePass_Fragment changePassFragment = new ChangePass_Fragment();
                fragmentTransaction.replace(R.id.frameLayout, changePassFragment);
                fragmentTransaction.commit();
            }
        });

        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Profile", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}