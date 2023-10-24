package com.example.foodapp;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.foodapp.Fragment_Customer.ChangePass_Fragment;
import com.example.foodapp.Login.LoginActivity;
import com.example.foodapp.R;
public class MoreFragment extends Fragment {

    private TextView profile, manager_acc, change_pass;
    private ImageView logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        profile = view.findViewById(R.id.profile);
        manager_acc = view.findViewById(R.id.manager_acc);
        change_pass = view.findViewById(R.id.change_pass);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                ProfileFragment profileFragment = new ProfileFragment();
                transaction.add(R.id.frameLayout, profileFragment);
                transaction.commit();
            }
        });
        manager_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ReviewPageFragment reviewpageFragment = new ReviewPageFragment();
                fragmentTransaction.replace(R.id.frameLayout, reviewpageFragment);
                fragmentTransaction.commit();
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ChangePassFragment changePassFragment = new ChangePassFragment();
                fragmentTransaction.replace(R.id.frameLayout, changePassFragment);
                fragmentTransaction.commit();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
