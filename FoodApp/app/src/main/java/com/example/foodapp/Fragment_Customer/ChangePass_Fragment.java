package com.example.foodapp.Fragment_Customer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.foodapp.R;


public class ChangePass_Fragment extends Fragment {

    private Button btnResert, btnSave;
    private EditText passOld, passNew, retypePass;

    private ImageView img_Back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_pass_, container, false);
        passOld = view.findViewById(R.id.pass_old);
        passNew = view.findViewById(R.id.pass_new);
        retypePass = view.findViewById(R.id.retype_passnew);
        btnResert = view.findViewById(R.id.btn_resert);
        btnSave = view.findViewById(R.id.btn_save);

        img_Back = view.findViewById(R.id.img_back_changepass);

        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayout, new More_Fragment()).commit();
            }
        });

        btnResert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passOld.setText("");
                passNew.setText("");
                retypePass.setText("");
            }
        });

        return view;
    }
}