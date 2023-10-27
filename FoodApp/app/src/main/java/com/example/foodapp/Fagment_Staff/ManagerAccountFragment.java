package com.example.foodapp.Fagment_Staff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodapp.R;

public class ManagerAccountFragment extends Fragment {

    private TextView txtEdit;
    private Button btnAddAcc;
    private ImageView img_Back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_account, container, false);
        txtEdit = view.findViewById(R.id.txt_editacc);
        btnAddAcc = view.findViewById(R.id.btn_addcount);

        img_Back = view.findViewById(R.id.img_BackManager);
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_Accounteditacc, new MoreFragment_Staff()).commit();
            }
        });

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
                fragmentTransaction.add(R.id.frame_Accounteditacc, new AddAccountSatff_Fragment());
                fragmentTransaction.commit();
            }
        });
    return view;
    }
}
