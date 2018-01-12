package com.demo.demo500px.main;

import com.demo.demo500px.data.model.Image;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public interface MainView {

    void setupAdapter(List<Image> images);

    void openImage(long id, String url);

    void failMessage(String msg);
}
