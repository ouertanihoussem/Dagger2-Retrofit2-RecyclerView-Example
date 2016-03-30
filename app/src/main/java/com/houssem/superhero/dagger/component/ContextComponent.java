package com.houssem.coemygrouphero.dagger.component;

import com.houssem.coemygrouphero.dagger.modules.ContextModule;
import com.houssem.coemygrouphero.utils.Storage;

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
