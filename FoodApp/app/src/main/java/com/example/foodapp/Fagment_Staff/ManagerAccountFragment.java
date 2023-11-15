package com.example.foodapp.Fagment_Staff;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.Interface.Deletestaff;
import com.example.foodapp.Model.Staff;
import com.example.foodapp.R;
import com.example.foodapp.adapter_staff.StaffAdapter;
import com.example.foodapp.config.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagerAccountFragment extends Fragment implements StaffAdapter.Deletestaff {

    private TextView txtEdit;
    private Button btnAddAcc;
    private ImageView img_Back;

    public List<Staff> staffList;

    public RecyclerView recyclerView;


    public StaffAdapter staffAdapter ;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_account, container, false);
        txtEdit = view.findViewById(R.id.txt_editacc);
        btnAddAcc = view.findViewById(R.id.btn_addcount);

        img_Back = view.findViewById(R.id.img_BackManager);

        staffList = new ArrayList<>();
        staffAdapter = new StaffAdapter(staffList);

        recyclerView = view.findViewById(R.id.rcystaff);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(staffAdapter);

        getds(getContext());
        staffAdapter.xoa(this);

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

    public  void  getds(Context context){
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(Request.Method.GET, Config.IP + "staff", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject perObject = new JSONObject(response);
                    JSONArray dataJson = perObject.getJSONArray("dataJson");
                    for (int i =0;i< dataJson.length();i++){
                        JSONObject jsonObject = dataJson.getJSONObject(i).getJSONObject("data");
                        Staff staff = new Staff();
                        staff.setName(jsonObject.getString("name"));
                        staff.setSex(jsonObject.getString("sex"));
                        JSONArray jsonArray = jsonObject.getJSONArray("staff");
                        List<Staff.staff> list = new ArrayList<>();
                        for (int a =0;a< jsonArray.length();a++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(a);
                            Staff.staff staff1 = new Staff.staff();
                            staff1.setId(jsonObject1.getString("_id"));
                            list.add(staff1);
                        }
                        staff.setStaff(list);
                        staffList.add(staff);
                    }
                    staffAdapter.notifyDataSetChanged();

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
    @Override
    public void delete(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("DELETE ?");
        builder.setMessage("bạn có muốn xóa không ?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                xoa(position);
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }
    public  void xoa(int position){
        String url = Config.IP + "deleteStaff/" + staffList.get(position).getStaff().get(0).getId();
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                staffList.remove(position);
                staffAdapter.notifyItemRemoved(position);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}