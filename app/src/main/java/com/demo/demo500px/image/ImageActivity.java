package com.demo.demo500px.image;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.demo.demo500px.R;
import com.demo.demo500px.data.model.Comment;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public class ImageActivity extends AppCompatActivity implements ImageView, View.OnClickListener {

    private ImagePresenter mPresenter;

    private RecyclerView mReyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        Button mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);

        android.widget.ImageView image = findViewById(R.id.imageView);
        Glide.with(this).load(getIntent().getStringExtra("url")).into(image);

        mEditText = findViewById(R.id.editText);
        mReyclerView = findViewById(R.id.comments_list);

        mReyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mReyclerView.setLayoutManager(mLayoutManager);

        mPresenter = new ImagePresenterImpl(this);
        mPresenter.loadComments(getIntent().getLongExtra("id", -1));
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                String text = mEditText.getText().toString();
                if (!text.isEmpty()) {
                    mPresenter.addComment(
                            getIntent().getLongExtra("id", -1),
                            text);
                }
                break;
        }
    }

    @Override
    public void showComments(List<Comment> comments) {
        mAdapter = new CommentsAdapter(comments);
        mReyclerView.setAdapter(mAdapter);
    }

    @Override
    public Context context() {
        return this;
    }
}
