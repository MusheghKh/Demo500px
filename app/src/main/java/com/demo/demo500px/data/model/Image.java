package com.demo.demo500px.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by max on 1/12/18.
 */

public class Image {

    private long id;

    private String name;

    @SerializedName("image_url")
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
