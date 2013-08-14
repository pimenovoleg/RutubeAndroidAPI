package com.volleyapi.model;

/**
 * Created by oleg on 8/14/13.
 */
public class VideoVO {

    private String id;
    private String title;
    private String description;
    private AuthorVO author;
    private String created_ts;
    private Boolean is_hidden;
    private String video_url;
    private Boolean has_high_quality;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuthorVO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorVO author) {
        this.author = author;
    }


    public String getCreated_ts() {
        return created_ts;
    }

    public void setCreated_ts(String created_ts) {
        this.created_ts = created_ts;
    }

    public Boolean getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(Boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public Boolean getHas_high_quality() {
        return has_high_quality;
    }

    public void setHas_high_quality(Boolean has_high_quality) {
        this.has_high_quality = has_high_quality;
    }
}
