package com.demo.demo500px.main;

import com.demo.demo500px.data.model.Page;
import com.demo.demo500px.data.remote.NetworkManager;
import com.demo.demo500px.data.remote.Service500Px;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by max on 1/12/18.
 */

public class MainPresenterImpl implements MainPresenter{

    private MainView mView;

    public MainPresenterImpl(MainView mView) {
        this.mView = mView;
    }

    @Override
    public void showImage(long id, String url) {
        mView.openImage(id, url);
    }

    @Override
    public void downloadImages() {
        NetworkManager.get500pcService().getPhotos(Service500Px.CONSUMER_KEY).enqueue(new Callback<Page>() {
            @Override
            public void onResponse(Call<Page> call, Response<Page> response) {
                mView.setupAdapter(response.body().getPhotos());
            }

            @Override
            public void onFailure(Call<Page> call, Throwable t) {
                mView.failMessage(t.toString());
            }
        });
    }

    @Override
    public void destroy() {
        mView = null;
    }
}
