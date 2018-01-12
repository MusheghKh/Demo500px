package com.demo.demo500px.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public class Page {

    @SerializedName("current_page")
    private int currentPage;

    private List<Image> photos;

    public int getmCurrentPage() {
        return currentPage;
    }

    public void setmCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Image> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Image> photos) {
        this.photos = photos;
    }
}
