package com.volleyapi.services.helpers;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by oleg on 7/30/13.
 */
public class GSONRequestBuilder<T> {

    /**
     * @param url - урл api
     * @return
     */
    public GSONRequestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @param headers - заголовки запроса к api
     * @return
     */
    public GSONRequestBuilder setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * обработчик "удачного" ответа от сервиса api
     * @param listener
     * @return
     */
    public GSONRequestBuilder setListener(Response.Listener<T> listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Обработчик ответа ошибки от api
     * @param errorListener
     * @return
     */
    public GSONRequestBuilder setErrorListener(Response.ErrorListener errorListener) {
        this.errorListener = errorListener;
        return this;
    }

    public GSONRequestBuilder setType(Type type) {
        this.type = type;
        return this;
    }

    public GSONRequestBuilder setMethod(int method) {
        this.method = method;
        return this;
    }

    public GSONRequestBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public GSONRequestBuilder setBody(Object body) {
        Gson gson = new Gson();
        setBody(gson.toJson(body));
        return this;
    }

    public GSONRequest createJsonRequest() {
        GSONRequest request = new GSONRequest(url, type, headers, listener, errorListener, method, body);
        return request;
    }

    private String url;
    private Map<String, String> headers;
    private Response.Listener<T> listener;
    private Response.ErrorListener errorListener;
    private Type type = new TypeToken<T>() {}.getType();
    private int method = Request.Method.GET;
    private String body;
}