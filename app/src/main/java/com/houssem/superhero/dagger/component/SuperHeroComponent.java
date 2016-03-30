package com.houssem.superhero.dagger.component;

import com.houssem.superhero.api.RetrofitSuperHeroImpl;
import com.houssem.superhero.dagger.modules.ServiceCreatorModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Formation on 25/03/2016.
 */
@Singleton
@Component(modules = ServiceCreatorModule.class)
public interface SuperHeroComponent {
//    SuperHero superHero();
    void inject(RetrofitSuperHeroImpl retrofitSuperHero);
}
