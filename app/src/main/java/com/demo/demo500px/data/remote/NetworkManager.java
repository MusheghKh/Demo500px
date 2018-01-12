package com.demo.demo500px.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by max on 1/12/18.
 */

public class NetworkManager {

    public static Service500Px get500pcService(){
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Service500Px.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit.create(Service500Px.class);
    }
}
