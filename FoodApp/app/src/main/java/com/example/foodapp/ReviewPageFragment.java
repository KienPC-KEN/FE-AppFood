package com.example.foodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodapp.Fagment_Staff.EditAccount_Staff_Fragment;

public class ReviewPageFragment extends Fragment {

    private TextView txtEdit;
    private Button btnAddAcc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review_page, container, false);
        txtEdit = view.findViewById(R.id.txt_editacc);
        btnAddAcc = view.findViewById(R.id.btn_addcount);

        txtEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =  fragmentManager.beginTransaction();
                EditAccount_Staff_Fragment editAccountStaffFragment = new EditAccount_Staff_Fragment();
                transaction.add(R.id.frame_Accounteditacc, editAccountStaffFragment);
                transaction.commit();
            }
        });

        btnAddAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  manager.beginTransaction();
                EditAccount_Staff_Fragment editAccountStaffFragment = new EditAccount_Staff_Fragment();
                fragmentTransaction.add(R.id.frame_Accounteditacc, editAccountStaffFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
