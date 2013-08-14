package com.volleyapi;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import com.android.volley.VolleyError;
import com.volleyapi.model.EditorsFeedVO;
import com.volleyapi.services.FeedsServiceImpl;
import com.volleyapi.services.delegates.FeedsServiceDelegate;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FeedsServiceImpl feedsService = new FeedsServiceImpl(this, new FeedsServiceDelegate() {
            @Override
            public void onResponseEditorsFeedComplete(EditorsFeedVO editorsFeedVO) {
                Log.d("FeedsServiceImpl", "initTabs done: " + editorsFeedVO);
            }

            @Override
            public void onResponseEditorsFeedError(VolleyError error) {
                Log.d("FeedsServiceImpl", "initTabs error: " + error);
            }
        });

        feedsService.getEditorFeed(1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
