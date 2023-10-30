package com.example.foodapp.config;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static final String TAG = "volleySingleton";
    private RequestQueue mRequestQueue;
    private static VolleySingleton sInstance;
    public VolleySingleton(Context context) {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
    }
    public static synchronized VolleySingleton getInstance(Context context) {
        if(sInstance == null) {
            sInstance = new VolleySingleton(context);
        }
        return sInstance;
    }
    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
