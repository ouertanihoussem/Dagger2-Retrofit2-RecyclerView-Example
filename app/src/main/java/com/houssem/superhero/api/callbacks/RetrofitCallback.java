package com.houssem.superhero.api.callbacks;

import android.util.Log;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Formation on 24/03/2016.
 */
public class RetrofitCallback<T> implements Callback<T> {

    private static final String TAG = RetrofitCallback.class.getName();

    ResponseListener listener;

    public RetrofitCallback(ResponseListener aListener){
        listener = aListener;
    }

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        listener.onResponse(response);
    }

    @Override
    public void onFailure(Throwable t) {
        Log.w(TAG, t.getLocalizedMessage());
    }
}
