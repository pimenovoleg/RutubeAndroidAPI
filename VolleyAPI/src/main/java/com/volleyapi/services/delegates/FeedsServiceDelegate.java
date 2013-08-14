package com.volleyapi.services.delegates;

import com.android.volley.VolleyError;
import com.volleyapi.model.EditorsFeedVO;

public interface FeedsServiceDelegate {
    public void onResponseEditorsFeedComplete(EditorsFeedVO editorsFeedVO);
    public void onResponseEditorsFeedError(VolleyError error);
}
