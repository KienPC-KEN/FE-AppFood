package com.example.foodapp.Fagment_Staff;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.foodapp.R;
import com.example.foodapp.ReviewPageFragment;

import java.util.Calendar;


public class AddAccountSatff_Fragment extends Fragment {
    private EditText edt_Ten, edt_SDT, edt_Pass, edt_Date, edt_Email, edt_Address;
    private Button btn_SelectImg, btn_Resert, btn_Save;

    private ImageView img_Back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_account_, container, false);

        edt_Ten = view.findViewById(R.id.edt_name_account);
        edt_SDT = view.findViewById(R.id.edt_phone_account);
        edt_Pass = view.findViewById(R.id.edt_pass_account);
        edt_Date = view.findViewById(R.id.edt_date_account);
        edt_Email = view.findViewById(R.id.edt_email_account);
        edt_Address = view.findViewById(R.id.edt_address_account);

        btn_Resert = view.findViewById(R.id.btn_resertAcc);
        btn_Save = view.findViewById(R.id.btn_saveAcc);
        btn_SelectImg = view.findViewById(R.id.select_img_addaccount);

        img_Back = view.findViewById(R.id.img_back_addaccount);

        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =  fragmentManager.beginTransaction();
                ReviewPageFragment reviewPageFragment = new ReviewPageFragment();
                transaction.replace(R.id.frameLayout_Addaccount, reviewPageFragment);
                transaction.commit();
            }
        });

        final Calendar calendar = Calendar.getInstance();
        final  int year = calendar.get(Calendar.YEAR);
        final  int month = calendar.get(Calendar.MONTH);
        final  int day = calendar.get(Calendar.DAY_OF_MONTH);
        edt_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        edt_Date.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        btn_Resert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_Ten.setText("");
                edt_SDT.setText("");
                edt_Pass.setText("");
                edt_Date.setText("");
                edt_Email.setText("");
                edt_Address.setText("");
            }
        });
        return view;
    }
}