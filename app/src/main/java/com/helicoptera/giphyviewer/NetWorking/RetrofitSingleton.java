package com.helicoptera.giphyviewer.NetWorking;

import NetWorking.GiphyAPIProvider;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static RetrofitSingleton mInstance;
    private static final String BASE_URL = "http://api.giphy.com/v1/gifs/";
    private Retrofit mRetrofit;

    private RetrofitSingleton() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public synchronized static RetrofitSingleton getInstance() {
        if (mInstance == null) {
                mInstance = new RetrofitSingleton();
            }
        return mInstance;
    }

    public GiphyAPIProvider getAPI() {
        return mRetrofit.create(GiphyAPIProvider.class);
    }


}