package com.houssem.superhero.dagger.modules;

/**
 * Created by Formation on 25/03/2016.
 */

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * This module provides the application context
 */
@Module
public class ContextModule {

    private final Context context;

    /**
     * We add a constructor so we can provide the app context at run time
     * @param context the created app
     */
    public ContextModule(Context context) {
        this.context = context;
    }

    /**
     * Dagger2 call this method to get the context
     * @return the app context
     */
    @Provides
    Context provideContext() {
        return context;
    }

}
