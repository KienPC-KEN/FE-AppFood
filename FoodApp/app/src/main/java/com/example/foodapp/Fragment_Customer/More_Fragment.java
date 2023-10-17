package com.example.foodapp.Fragment_Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodapp.Login.LoginActivity;
import com.example.foodapp.R;

public class More_Fragment extends Fragment {

    private TextView txtProfile, txtChangePass, txtLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_more_customer, container, false);
       txtProfile = view.findViewById(R.id.txt_profile_more);
       txtChangePass = view.findViewById(R.id.txt_changePass);
       txtLogout = view.findViewById(R.id.txt_logout);

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
               Intent intent = new Intent(getActivity(), LoginActivity.class);
               startActivity(intent);
           }
       });
       return view;
    }
}