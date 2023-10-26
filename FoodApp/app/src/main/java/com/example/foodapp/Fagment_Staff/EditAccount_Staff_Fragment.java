package com.example.foodapp.Fagment_Staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodapp.R;


public class EditAccount_Staff_Fragment extends Fragment {

    private EditText edit_Ten, edit_SDT, edit_Phone, edit_pass, edit_Date, edit_Address;
    private Button btn_ResertEdit, btn_SaveEdit, btn_EditImg;
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
        edit_Address = view.findViewById(R.id.edt_editAddress_acc);

        btn_EditImg = view.findViewById(R.id.select_editimg);
        btn_ResertEdit = view.findViewById(R.id.btn_edit_resertAcc);
        btn_SaveEdit = view.findViewById(R.id.btn_edit_saveAcc);
        return  view;
    }
}