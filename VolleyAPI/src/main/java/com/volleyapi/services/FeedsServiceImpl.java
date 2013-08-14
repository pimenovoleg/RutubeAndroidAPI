package com.volleyapi.services;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.volleyapi.model.EditorsFeedVO;
import com.volleyapi.services.delegates.FeedsServiceDelegate;
import com.volleyapi.services.helpers.BasicService;
import com.volleyapi.services.helpers.GenericServiceImpl;
import com.volleyapi.services.interfaces.FeedsService;

/**
 * Реализация обработки запросов к веб-сервису
 * FeedsServiceImpl feedsService = new FeedsServiceImpl(this, new FeedsServiceDelegate() {
 *      @Override
 *      public void onResponseEditorsFeedComplete(EditorsFeedVO editorsFeedVO) {
 *          Log.d(LOG_TAG, "initTabs done" + editorsFeedVO);
 *      }
 *
 *      @Override
 *      public void onResponseEditorsFeedError(VolleyError error) {
 *          Log.d(LOG_TAG, "initTabs done" + error);
 *      }
 *  });
 *
 *  feedsService.getEditorFeed(args...);
 *
 *  Так же возможно сделать имплементация интерфейса глобально на Activity/Fragment
 *
 * Created by oleg on 7/30/13.
 */
public class FeedsServiceImpl extends BasicService implements FeedsService {

    public FeedsServiceImpl(Context context, FeedsServiceDelegate serviceDelegate) {
        super(context);
        this.serviceDelegate = serviceDelegate;
    }

    @Override
    public void getEditorFeed(Integer pageNumber) {
        GenericServiceImpl<EditorsFeedVO> operator = new GenericServiceImpl<EditorsFeedVO>(getRequestQueue(), EditorsFeedVO.class);
        operator.execute(SERVICE_URL + "page=" + pageNumber,
                new Response.Listener<EditorsFeedVO>() {
                    @Override
                    public void onResponse(EditorsFeedVO response) {
                        // обработка данных, необходимое сохранение и тд
                        // в Activity мы дожлны вернуть уже сформированный объект данных
                        serviceDelegate.onResponseEditorsFeedComplete(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        serviceDelegate.onResponseEditorsFeedError(error);
                    }
                });
    }

    private static String SERVICE_URL = "http://rutube.ru/api/video/editors/?";
    private FeedsServiceDelegate serviceDelegate;
}
