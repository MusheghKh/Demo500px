package com.demo.demo500px.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo.demo500px.R;
import com.demo.demo500px.data.model.Image;
import com.demo.demo500px.image.ImageActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.images_recycler);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mPresenter = new MainPresenterImpl(this);
        mPresenter.downloadImages();
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void setupAdapter(List<Image> images) {
        mAdapter = new ImagesAdapter(images, mPresenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void openImage(long id, String url) {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    public void failMessage(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
