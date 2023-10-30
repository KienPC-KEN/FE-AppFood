package com.example.foodapp.config;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static final String TAG = "volleySingleton";
    private RequestQueue requestQueue;
    private static VolleySingleton instance;
    public VolleySingleton(Context context) {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
    }
    public static synchronized VolleySingleton getInstance(Context context) {
        if(instance == null) {
            instance = new VolleySingleton(context);
        }
        return instance;
    }
    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
