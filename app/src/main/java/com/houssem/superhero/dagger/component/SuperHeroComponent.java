package com.houssem.coemygrouphero.dagger.component;

import com.houssem.coemygrouphero.api.RetrofitSuperHeroImpl;
import com.houssem.coemygrouphero.dagger.modules.ServiceCreatorModule;

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
