package com.example.foodapp.adapter_staff;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Interface.Deletestaff;
import com.example.foodapp.Model.Staff;
import com.example.foodapp.R;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder> {

    public List<Staff> staffList;
    private Deletestaff deletestaff;

    public StaffAdapter(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public interface Deletestaff {
        void delete(int position);
    }


    @NonNull
    @Override
    public StaffAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review_page,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffAdapter.ViewHolder holder, int position) {
        Staff staff = staffList.get(position);
        holder.tv1.setText(staff.getName());
        holder.tv2.setText(staff.getSex());

        holder.btntesst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("sdasdsa","sadd");
            }
        });


    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tv1;
        TextView tv2;
        ImageView imgedit;
        ImageView imgdelete;

        Button btntesst;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.avt_profile);
            tv1 = itemView.findViewById(R.id.idten);
            tv2 = itemView.findViewById(R.id.idgioitinh);
            imgedit =itemView.findViewById(R.id.editmng);
            imgdelete =itemView.findViewById(R.id.deletemng);
            btntesst = itemView.findViewById(R.id.btntesst);




            imgdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (deletestaff!=null){
                        int position =  getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION){
                            deletestaff.delete(position);

                        }
                    }
                }
            });
            imgedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("sdasdsa","sadd");
                }
            });
        }
    }

    public void xoa(Deletestaff deletestaff){
        this.deletestaff = deletestaff;
    }

}