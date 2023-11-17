package com.example.foodapp.Fragment_Customer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Fagment_Staff.MoreFragment_Staff;
import com.example.foodapp.R;
import com.example.foodapp.databinding.FragmentProfileBinding;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class Profile_Fragment extends Fragment {
    public FragmentProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imgBack.setOnClickListener(v -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new More_Fragment()).commit());

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        String name = sharedPreferences.getString("name", "");
        String phone = sharedPreferences.getString("phone", "");
        String date = sharedPreferences.getString("date", "");
        String gender = sharedPreferences.getString("sex", "");
        String email = sharedPreferences.getString("email", "");
        String address = sharedPreferences.getString("address", "");
        String image = sharedPreferences.getString("image", "");

        getDataUserStaff(name, phone, date, gender, email, address, image);

        editChange(id);
    }

    private void getDataUserStaff(String name, String phone, String date, String gender, String email, String address, String image) {
        binding.edtName.setText(name);
        binding.edtPhone.setText(phone);
        binding.edtDate.setText(date);
        binding.edtGender.setText(gender);
        binding.edtMail.setText(email);
        binding.edtAddress.setText(address);
        binding.edtImage.setText(image);

        Glide.with(requireActivity()).load(image).centerCrop().into(binding.imgAvt);
    }

    public void editChange(String id) {
        binding.editSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.layoutName.setEnabled(true);
                binding.layoutPhone.setEnabled(true);
                binding.layoutDate.setEnabled(true);
                binding.layoutGender.setEnabled(true);
                binding.layoutMail.setEnabled(true);
                binding.layoutAddress.setEnabled(true);
                binding.layoutImage.setVisibility(View.VISIBLE);
            } else {
                binding.layoutName.setEnabled(false);
                binding.layoutPhone.setEnabled(false);
                binding.layoutDate.setEnabled(false);
                binding.layoutGender.setEnabled(false);
                binding.layoutMail.setEnabled(false);
                binding.layoutAddress.setEnabled(false);
                binding.layoutImage.setVisibility(View.GONE);
            }
        });
    }
}