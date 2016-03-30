package com.houssem.coemygrouphero.api;

import com.houssem.coemygrouphero.api.callbacks.RetrofitCallback;
import com.houssem.coemygrouphero.pojo.Heros;


/**
 * Created by Formation on 24/03/2016.
 */
public interface SuperHero {

    void getHeros(RetrofitCallback<Heros> call);
}
