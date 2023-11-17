package com.example.foodapp.Fagment_Staff;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentProfileStaffBinding;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProfileFragment_Staff extends Fragment {
    private static final String TAG = "ProfileStaffFragment";
    public FragmentProfileStaffBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileStaffBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imgBack.setOnClickListener(v -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MoreFragment_Staff()).commit());

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("_id", "");
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
                VolleySingleton.getInstance(requireActivity()).addToRequestQueue(new StringRequest(Request.Method.PUT, Config.IP + "staff/updateStaff/" + id, response -> {
                    Toast.makeText(requireActivity(), "onSuccess!", Toast.LENGTH_SHORT).show();
                }, error -> {
                    Toast.makeText(requireActivity(), "onFailure: " + error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("name", Objects.requireNonNull(binding.edtName.getText()).toString());
                        params.put("phone", Objects.requireNonNull(binding.edtPhone.getText()).toString());
                        params.put("sex", binding.edtGender.getText().toString());
                        params.put("date", Objects.requireNonNull(binding.edtDate.getText()).toString());
                        params.put("email", Objects.requireNonNull(binding.edtMail.getText()).toString());
                        params.put("address", Objects.requireNonNull(binding.edtAddress.getText()).toString());
                        params.put("image", Objects.requireNonNull(binding.edtImage.getText()).toString());
                        return params;
                    }
                });
            }
        });
    }
}
