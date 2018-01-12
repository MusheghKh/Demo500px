package com.demo.demo500px.main;

/**
 * Created by max on 1/12/18.
 */

public interface MainPresenter {

    void showImage(long id, String url);

    void downloadImages();

    void destroy();
}
