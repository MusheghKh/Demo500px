package com.demo.demo500px.data.remote;

import com.demo.demo500px.data.model.Image;
import com.demo.demo500px.data.model.Page;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by max on 1/12/18.
 */

public interface Service500Px {

    String URL = "https://api.500px.com/";
    String CONSUMER_KEY = "87nZqTak68np5TZ5KSDPsvAY6wdYOucOuF9AJt0G";

    @GET("/v1/photos")
    Call<Page> getPhotos(@Query("consumer_key") String key);

    @GET("v1/photos/{id}")
    Call<Image> getPhotoById(@Path("id") String id, @Query("consumer_key") String key);
}
