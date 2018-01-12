package com.demo.demo500px.image;

/**
 * Created by max on 1/12/18.
 */

public interface ImagePresenter {

    void addComment(long id, String text);

    void loadComments(long id);

    void destroy();

}
