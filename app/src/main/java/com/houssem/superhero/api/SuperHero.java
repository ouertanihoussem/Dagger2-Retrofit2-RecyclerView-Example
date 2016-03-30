package com.houssem.superhero.api;

import com.houssem.superhero.api.callbacks.RetrofitCallback;
import com.houssem.superhero.pojo.Heros;


/**
 * Created by Formation on 24/03/2016.
 */
public interface SuperHero {

    void getHeros(RetrofitCallback<Heros> call);
}
