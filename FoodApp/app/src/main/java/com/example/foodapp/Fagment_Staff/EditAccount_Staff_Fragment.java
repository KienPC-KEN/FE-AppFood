package com.example.foodapp.Fagment_Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.foodapp.R;


public class EditAccount_Staff_Fragment extends Fragment {

    private EditText edit_Ten, edit_SDT, edit_Phone, edit_pass, edit_Date, edt_Email, edit_Address, edit_Img;
    private Button btn_ResertEdit, btn_SaveEdit;
    private ImageView img_BackEdit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_account__staff_, container, false);
        edit_Ten = view.findViewById(R.id.edt_editname_acc);
        edit_SDT = view.findViewById(R.id.edt_editphone_acc);
        edit_Phone = view.findViewById(R.id.edt_editphone_acc);
        edit_pass = view.findViewById(R.id.edt_editpass_acc);
        edit_Date = view.findViewById(R.id.edt_editdate_acc);
        edt_Email = view.findViewById(R.id.edt_editemail_acc);
        edit_Address = view.findViewById(R.id.edt_editAddress_acc);
        edit_Img = view.findViewById(R.id.edt_editImg_acc);

        btn_ResertEdit = view.findViewById(R.id.btn_edit_resertAcc);
        btn_SaveEdit = view.findViewById(R.id.btn_edit_saveAcc);

        img_BackEdit = view.findViewById(R.id.img_back_editaccount);
        img_BackEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =  fragmentManager.beginTransaction();
                ManagerAccountFragment managerAccountFragment = new ManagerAccountFragment();
                transaction.replace(R.id.frame_Accounteditacc, managerAccountFragment);
                transaction.commit();
            }
        });

        btn_ResertEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_Ten.setText("");
                edit_Phone.setText("");
                edit_pass.setText("");
                edit_Date.setText("");
                edt_Email.setText("");
                edit_Address.setText("");
                edit_Img.setText("");
            }
        });
        return  view;
    }
}