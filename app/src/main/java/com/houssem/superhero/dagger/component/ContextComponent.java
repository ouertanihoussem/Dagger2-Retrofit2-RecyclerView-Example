package com.houssem.superhero.dagger.component;

import com.houssem.superhero.dagger.modules.ContextModule;
import com.houssem.superhero.utils.Storage;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Formation on 29/03/2016.
 */
@Singleton
@Component(modules = ContextModule.class)
public interface ContextComponent {

    void inject(Storage storage);
}
