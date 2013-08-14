package com.volleyapi.model;

/**
 * Created by oleg on 8/14/13.
 */
public class EditorsFeedItemVO {

    private Integer id;
    private String message;
    private String posting_ts;
    private AuthorVO last_poster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPosting_ts() {
        return posting_ts;
    }

    public void setPosting_ts(String posting_ts) {
        this.posting_ts = posting_ts;
    }

    public AuthorVO getLast_poster() {
        return last_poster;
    }

    public void setLast_poster(AuthorVO last_poster) {
        this.last_poster = last_poster;
    }
}
