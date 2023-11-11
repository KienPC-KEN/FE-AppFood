package com.example.foodapp.Fragment_Customer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class Profile_Fragment extends Fragment {

    private ImageView img_Back;
    private TextView tvName, tvPhone, tvDate, tvSex, tvEmail, tvAddress;

    private CircleImageView imgAvatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_, container, false);
        img_Back = view.findViewById(R.id.img_backprofile);
        tvName = view.findViewById(R.id.txt_NamePro);
        tvPhone = view.findViewById(R.id.txt_PhonePro);
        tvDate = view.findViewById(R.id.txt_DatePro);
        tvSex = view.findViewById(R.id.txt_SexPro);
        tvEmail = view.findViewById(R.id.txt_EmailPro);
        tvAddress = view.findViewById(R.id.txt_AddressPro);
        imgAvatar = view.findViewById(R.id.imagePro);
        getDataUser();
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frameLayout, new More_Fragment()).commit();
                Log.d("Back", "onClick: ");
            }
        });

        return view;
    }

    private void getDataUser() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String phone = sharedPreferences.getString("phone", "");
        String date = sharedPreferences.getString("date", "");
        String sex = sharedPreferences.getString("sex", "");
        String image = sharedPreferences.getString("image", "");
        String email = sharedPreferences.getString("email", "");
        String address = sharedPreferences.getString("address", "");

        tvName.setText(name);
        tvPhone.setText(phone);
        tvDate.setText(date);
        tvSex.setText(sex);
        tvEmail.setText(email);
        tvAddress.setText(address);

        Glide.with(getActivity()).load(image).centerCrop().into(imgAvatar);
    }
}