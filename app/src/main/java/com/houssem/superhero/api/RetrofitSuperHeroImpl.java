package com.houssem.superhero.api;

import com.houssem.superhero.api.callbacks.RetrofitCallback;
import com.houssem.superhero.dagger.Application;
import com.houssem.superhero.pojo.Heros;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Formation on 24/03/2016.
 */
public class RetrofitSuperHeroImpl implements SuperHero{

    @Inject
    SuperHeroService superHeroService;

    public interface SuperHeroService {
        String baseURL = "http://coemygroup.fr"; // example http://houssem.fr
        /**
         * Method to load the list of super heros from a remote json file (test2.json)
         */
        @GET("/test-mobile/iOS/json/test2.json")
        Call<Heros> loadHeros();
    }

    public RetrofitSuperHeroImpl(){Application.app().getSuperHeroComponent().inject(this);}

    @Override
    public void getHeros(RetrofitCallback<Heros> callback) {
        final Call<Heros> call = superHeroService.loadHeros();
        call.enqueue(callback);
    }

}
