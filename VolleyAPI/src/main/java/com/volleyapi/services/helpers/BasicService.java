package com.volleyapi.services.helpers;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class BasicService {

    public BasicService(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Останавливаем запрос.
     * Например, может вызываться на onDestroy
     */
    public void stopRequest() {
        getRequestQueue().stop();
    }

    public RequestQueue getRequestQueue() {
        return this.requestQueue;
    }

    private RequestQueue requestQueue;
}
