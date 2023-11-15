package com.example.foodapp.Fagment_Staff;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.Model.Staff;
import com.example.foodapp.R;
import com.example.foodapp.adapter_staff.StaffAdapter;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class AddAccountSatff_Fragment extends Fragment {
    private EditText edt_Ten, edt_SDT, edt_Pass, edt_Date, edt_Email, edt_Address, edt_Img;
    private Button btn_Resert, btn_Save;

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
        edt_Img = view.findViewById(R.id.edt_adImg_account);

        btn_Resert = view.findViewById(R.id.btn_resertAcc);
        btn_Save = view.findViewById(R.id.btn_saveAcc);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addstaff(getContext());
//                chuyenman();
            }
        });

        img_Back = view.findViewById(R.id.img_back_addaccount);

        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =  fragmentManager.beginTransaction();
                ManagerAccountFragment managerAccountFragment = new ManagerAccountFragment();
                transaction.replace(R.id.frame_Accounteditacc, managerAccountFragment);
                transaction.commit();
                Log.d("nutBack", "back");
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
                edt_Img.setText("");
            }
        });
        return view;
    }

    public  void  addstaff( Context context){

        VolleySingleton.getInstance(context).addToRequestQueue(new StringRequest(Request.Method.POST, Config.IP + "staff/addStaff", response -> {
            Toast.makeText(getContext(), "Create successfully", Toast.LENGTH_SHORT).show();

        }, error -> {
            Toast.makeText(getContext(), "Create failure: " + error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
            Log.e("Volley Error", "Create failure: " + error.networkResponse.statusCode);
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", edt_Ten.getText().toString());
                params.put("phone", edt_SDT.getText().toString());
                params.put("password", edt_Pass.getText().toString());
                params.put("date", edt_Date.getText().toString());
                params.put("email", edt_Email.getText().toString());
                params.put("address", edt_Address.getText().toString());
                params.put("image", edt_Img.getText().toString());
                return params;
            }
        });

//        RequestQueue queue = Volley.newRequestQueue(context);
//        JSONObject jsonObject = new JSONObject();
//
//        try {
//            Log.d("StaffData", "Name: " + staff.getName() + ", Phone: " + staff.getPhone() + ", ...");
//            // Đặt dữ liệu của Staff vào JSONObject
//            jsonObject.put("name", staff.getName());
//            jsonObject.put("phone", staff.getPhone());
//            jsonObject.put("password", staff.getPassword());
//            jsonObject.put("date", staff.getDate());
//            jsonObject.put("email", staff.getEmail());
//            jsonObject.put("address", staff.getAddress());
//            jsonObject.put("image", staff.getImage());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,jsonObject, new Response.Listener<JSONObject>(){
//
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("ServerResponse", response.toString());
//                chuyenman();
//            }
//
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Volley Error", error.toString());
//            }
//        });
//        request.setRetryPolicy(new DefaultRetryPolicy(
//                0,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        queue.add(request);

}
    @SuppressLint("ResourceType")
    private void chuyenman() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ManagerAccountFragment managerAccountFragment = new ManagerAccountFragment();
        fragmentTransaction.replace(R.id.ad1,managerAccountFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}