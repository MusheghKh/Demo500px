package com.demo.demo500px.image;

import com.demo.demo500px.data.local.CommentRepository;
import com.demo.demo500px.data.model.Comment;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public class ImagePresenterImpl implements ImagePresenter {

    private ImageView mView;
    private CommentRepository mCommentRepository;

    public ImagePresenterImpl(ImageView view) {
        this.mView = view;
        mCommentRepository = new CommentRepository(mView.context());
    }

    @Override
    public void addComment(long id, String text) {
        mCommentRepository.addComment(id, text);
        loadComments(id);
    }

    @Override
    public void loadComments(long id) {
        List<Comment> comments = mCommentRepository.getComments(id);
        mView.showComments(comments);
    }

    @Override
    public void destroy() {
        mView = null;
    }
}
