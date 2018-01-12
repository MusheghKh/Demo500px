package com.demo.demo500px.data.model;

/**
 * Created by max on 1/12/18.
 */

public class Comment {

    private long imageId;

    private String text;

    public Comment(long imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public long getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}
