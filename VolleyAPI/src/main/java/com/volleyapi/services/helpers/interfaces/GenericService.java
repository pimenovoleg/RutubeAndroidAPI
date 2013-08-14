package com.volleyapi.services.helpers.interfaces;

import com.android.volley.Response;

public interface GenericService<T> {
    void execute(String id, Response.Listener<T> listener, Response.ErrorListener errorListener);
}