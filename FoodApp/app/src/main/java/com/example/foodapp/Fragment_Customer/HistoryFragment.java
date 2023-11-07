package com.example.foodapp.Fragment_Customer;

import static com.example.foodapp.config.Config.IP;

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
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.Adapter_Customer.OrderDetailAdapter;
import com.example.foodapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HistoryFragment extends Fragment {
    private ArrayList<Map<String, String>> orderDetails = new ArrayList<>();
    OrderDetailAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.lvItem);
         adapter = new OrderDetailAdapter(getContext(), orderDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

       
        fetchDataFromAPI();

        return view;
    }

    private void fetchDataFromAPI() {
        String apiUrl = "http://" + IP + ":3000/api/order-detail/";
        RequestQueue queue = Volley.newRequestQueue(getContext(), new HurlStack());


        StringRequest stringRequest = new StringRequest(Request.Method.GET, apiUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject orderDetailObject = jsonArray.getJSONObject(i);
                                Map<String, String> orderDetailMap = new HashMap<>();
                                orderDetailMap.put("orderItem", orderDetailObject.getString("name"));
                                orderDetailMap.put("count", orderDetailObject.getJSONArray("idOrderItem").getJSONObject(0).getString("quantity"));
                                orderDetailMap.put("price", orderDetailObject.getJSONArray("idOrderItem").getJSONObject(0).getJSONObject("idProduct").getString("price"));
//                                orderDetailMap.put("discount", orderDetailObject.getJSONArray("idOrderItem").getJSONObject(0).getJSONObject("idProduct").getString("discount"));
                                orderDetailMap.put("discount", "10000");
                                orderDetails.add(orderDetailMap);
                            }

                           
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
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
                }

        );
        int timeout = 10000;  
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                timeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));


        queue.add(stringRequest);

    }

}

