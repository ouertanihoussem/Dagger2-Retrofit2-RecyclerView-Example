package com.houssem.superhero.api.callbacks;

import retrofit.Response;

/**
 * Created by Formation on 24/03/2016.
 */
public interface ResponseListener<T> {

    void onResponse(Response<T> response);
}
