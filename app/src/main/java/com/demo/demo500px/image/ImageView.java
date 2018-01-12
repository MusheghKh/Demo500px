package com.demo.demo500px.image;

import android.content.Context;

import com.demo.demo500px.data.model.Comment;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public interface ImageView {

    void showComments(List<Comment> comments);

    Context context();

}
