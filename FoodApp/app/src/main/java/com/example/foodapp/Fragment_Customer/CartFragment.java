package com.example.foodapp.Fragment_Customer;

import static com.example.foodapp.config.Config.IP;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.Adapter_Customer.CartAdapter;
import com.example.foodapp.Adapter_Customer.OrderDetailAdapter;
import com.example.foodapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private ArrayList<Map<String, String>> cartData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCart);
        cartAdapter = new CartAdapter(cartData, getContext());


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        recyclerView.setAdapter(cartAdapter);



        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE);
        String customerId = sharedPreferences.getString("customerId", "");
        getOrderItemsByIdCustomer(customerId);
        return view;
    }

    public void updateCartData(ArrayList<Map<String, String>> newCartData) {
        if (cartData != null) {
            cartData.clear();
            cartData.addAll(newCartData);
            cartAdapter.notifyDataSetChanged();
        } else {

            cartData = new ArrayList<>(newCartData);
            cartAdapter.notifyDataSetChanged();
        }
    }

    private void getOrderItemsByIdCustomer(String idCustomer) {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = IP + "order-item/getByIdCustomer/" + idCustomer; // Include idCustomer in the URL.

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            ArrayList<Map<String, String>> newCartData = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String productName = jsonObject.getJSONObject("idProduct").getString("name");

                                String productPrice = jsonObject.getJSONObject("idProduct").getString("price");
                                String quantity = jsonObject.getString("quantity");


                                String productTotal = jsonObject.getString("totalPrice");


                                Map<String, String> orderItem = new HashMap<>();
                                orderItem.put("productName", productName);
                                orderItem.put("productPrice", productPrice);
                                orderItem.put("productQuantity", quantity);
                                orderItem.put("productTotal", productTotal);

                                newCartData.add(orderItem);
                            }

                            cartAdapter.notifyDataSetChanged();
                            updateCartData(newCartData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Lỗi", "Lỗi khi lấy dữ liệu từ API: " + error.toString());

                if (error instanceof TimeoutError) {
                    Log.e("Lỗi", "Timeout Error");
                } else if (error instanceof NoConnectionError) {
                    Log.e("Lỗi", "No Connection Error");
                } else if (error instanceof NetworkError) {
                    Log.e("Lỗi", "Network Error");
                } else if (error instanceof ServerError) {
                    Log.e("Lỗi", "Server Error");
                } else if (error instanceof ParseError) {
                    Log.e("Lỗi", "Parse Error");
                } else {
                    Log.e("Lỗi", "Unknown Error");
                }

                Toast.makeText(getContext(), "Đã xảy ra lỗi khi lấy dữ liệu từ API", Toast.LENGTH_SHORT).show();
            }
        });
        int timeout = 10000;
        request.setRetryPolicy(new DefaultRetryPolicy(
                timeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));

        queue.add(request);
    }


}
