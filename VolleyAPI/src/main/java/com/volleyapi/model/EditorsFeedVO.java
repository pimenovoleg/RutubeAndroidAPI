package com.volleyapi.model;


import java.util.List;

public class EditorsFeedVO extends FeedsVO {

    private List<EditorsFeedItemVO> results;

    public List<EditorsFeedItemVO> getResults() {
        return results;
    }

    public void setResults(List<EditorsFeedItemVO> results) {
        this.results = results;
    }
}
