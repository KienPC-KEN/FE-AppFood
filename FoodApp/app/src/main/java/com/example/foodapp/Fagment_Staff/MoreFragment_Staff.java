package com.example.foodapp.Fagment_Staff;



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


import com.example.foodapp.Login.LoginActivity;
import com.example.foodapp.R;

public class MoreFragment_Staff extends Fragment {

    private TextView profile, manager_acc, change_pass;
    private ImageView logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_staff, container, false);
        profile = view.findViewById(R.id.profile);
        manager_acc = view.findViewById(R.id.manager_acc);
        change_pass = view.findViewById(R.id.change_pass);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                ProfileFragment_Staff profileFragment = new ProfileFragment_Staff();
                transaction.add(R.id.frameLayout, profileFragment);
                transaction.commit();
            }
        });
        manager_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ManagerAccountFragment managerAccountFragment = new ManagerAccountFragment();
                fragmentTransaction.replace(R.id.frameLayout, managerAccountFragment);
                fragmentTransaction.commit();
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ChangePassFragment_Staff changePassFragment = new ChangePassFragment_Staff();
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
