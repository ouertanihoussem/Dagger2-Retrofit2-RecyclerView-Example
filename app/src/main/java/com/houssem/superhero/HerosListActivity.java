package com.houssem.superhero;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.houssem.superhero.adapters.SuperHeroListAdapter;
import com.houssem.superhero.api.RetrofitSuperHeroImpl;
import com.houssem.superhero.api.callbacks.ResponseListener;
import com.houssem.superhero.api.callbacks.RetrofitCallback;
import com.houssem.superhero.pojo.Hero;
import com.houssem.superhero.pojo.Heros;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit.Response;

public class HerosListActivity extends AbstractActivity implements ResponseListener<Heros>{

    private RecyclerView herosList;
    private List<Hero> heros;
    private SuperHeroListAdapter superHeroListAdapter;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_heros_list;
    }

    @Override
    public void findViews() {
        herosList = (RecyclerView) findViewById(R.id.heros);
    }

    public void initializeUI() {

        RetrofitCallback<Heros> callback = new RetrofitCallback<>(this);
        RetrofitSuperHeroImpl retrofitSuperHero = new RetrofitSuperHeroImpl();
        retrofitSuperHero.getHeros(callback);
    }

    @Override
    public void onResponse(Response<Heros> response) {
        heros = response.body().elements;

        Collections.sort(heros, new Comparator<Hero>() {
            @Override
            public int compare(Hero lhs, Hero rhs) {
                return Integer.parseInt(lhs.getYear()) - Integer.parseInt(rhs.getYear());
            }
        });

        herosList.setLayoutManager(new LinearLayoutManager(this));

        superHeroListAdapter = new SuperHeroListAdapter(heros);

        herosList.setAdapter(superHeroListAdapter);
    }
}
