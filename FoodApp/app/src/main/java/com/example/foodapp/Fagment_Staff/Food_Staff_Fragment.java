package com.example.foodapp.Fagment_Staff;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.example.foodapp.Add_Product_Activity;
import com.example.foodapp.Model.Product;
import com.example.foodapp.R;
import com.example.foodapp.adapter_staff.S_Menu_ProductAdapter;
import com.example.foodapp.config.Config;
import com.example.foodapp.config.VolleySingleton;
import com.example.foodapp.databinding.FragmentFoodStaffBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;


public class Food_Staff_Fragment extends Fragment {
    private static final String TAG = "Staff_Food_Fragment";
    private ArrayList<Product> productData;
    private ArrayList<Product> listFoodProduct;
    private S_Menu_ProductAdapter adapter;
    private FragmentFoodStaffBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodStaffBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fabCreate.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Add_Product_Activity.class);
            intent.putExtra("category_type", "food");
            intent.putExtra("button_type", "create");
            startActivity(intent);
        });

        productData = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(requireActivity());
        binding.rcvFoodProductMenu.setLayoutManager(manager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
        binding.rcvFoodProductMenu.addItemDecoration(dividerItemDecoration);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rcvFoodProductMenu);
    }

    @Override
    public void onResume() {
        super.onResume();
        GETProduct();
        binding.getRoot().requestLayout();
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    public void GETProduct() {
        VolleySingleton.getInstance(getContext()).addToRequestQueue(new StringRequest(Config.IP + "Product", response -> {
            productData = new Gson().fromJson(response, new TypeToken<ArrayList<Product>>() {
            }.getType());
            listFoodProduct = new ArrayList<>();
            for (Product p :
                    productData) {
                if (p.getCategory().getType().equals("food")) {
                    listFoodProduct.add(p);
                }
            }
            adapter = new S_Menu_ProductAdapter(listFoodProduct);
            binding.rcvFoodProductMenu.setAdapter(adapter);
        }, error -> {
            Toast.makeText(getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
        }));
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int pos = viewHolder.getAbsoluteAdapterPosition();

            switch (direction) {
                case ItemTouchHelper.LEFT:
                    listFoodProduct.remove(pos);
                    adapter.notifyItemRemoved(pos);
                    break;
                case ItemTouchHelper.RIGHT:
                    Intent intent = new Intent(requireActivity(), Add_Product_Activity.class);
                    intent.putExtra("category_type", "food");
                    intent.putExtra("button_type", "update");
                    startActivity(intent);
                    break;
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.red))
                    .addSwipeLeftActionIcon(R.drawable.delete_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.green))
                    .addSwipeRightActionIcon(R.drawable.archive_24)
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };
}
