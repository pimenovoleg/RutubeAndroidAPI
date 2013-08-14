package com.volleyapi.services.helpers;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.volleyapi.services.helpers.interfaces.GenericService;

import java.util.HashMap;
import java.util.Map;

public class GenericServiceImpl<T> implements GenericService<T> {

    public GenericServiceImpl(RequestQueue requestQueue, Class<T> type) {
        this.requestQueue = requestQueue;
        this.clazz = type;

        mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type",  "application/json");
    }

    @Override
    public void execute(String id, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        String url = String.format(id);
        GSONRequestBuilder<T> builder = new GSONRequestBuilder<T>();
        builder.setUrl(url)
                .setListener(listener)
                .setErrorListener(errorListener)
                .setType(this.clazz);
        getFromBuilder(builder);
    }

    private Map<String, String> getMapHeaders() {
        return mapHeaders;
    }

    private void getFromBuilder(GSONRequestBuilder builder) {
        builder.setMethod(Request.Method.GET)
                .setHeaders(getMapHeaders())
                .createJsonRequest();
        requestQueue.add(builder.createJsonRequest());
        requestQueue.start();
    }

    private Map<String, String> mapHeaders;
    private RequestQueue requestQueue;
    private Class<T> clazz;
}