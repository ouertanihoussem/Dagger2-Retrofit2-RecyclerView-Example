package com.houssem.superhero.dagger;

import com.houssem.superhero.dagger.component.ContextComponent;
import com.houssem.superhero.dagger.modules.ContextModule;
import com.houssem.superhero.dagger.modules.ServiceCreatorModule;
import com.houssem.superhero.dagger.component.SuperHeroComponent;
import com.houssem.superhero.dagger.component.DaggerSuperHeroComponent;
import com.houssem.superhero.dagger.component.DaggerContextComponent;

/**
 * Created by Formation on 25/03/2016.
 */
public class Application extends android.app.Application {

    private SuperHeroComponent superHeroComponent;
    private ContextComponent contextComponent;
    protected static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        //I create SuperHeroComponent and save it in application
        superHeroComponent = DaggerSuperHeroComponent.builder()
                .serviceCreatorModule(new ServiceCreatorModule())
                .build();

        contextComponent = DaggerContextComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public static Application app() {
        return application;
    }

    //we can get the SuperHeroComponent thanks to Application().app.getSuperHeroComponent()
    public SuperHeroComponent getSuperHeroComponent() {
        return superHeroComponent;
    }

    //we can get the ContextComponent thanks to Application().app.getContextComponent()
    public ContextComponent getContextComponent() {
        return contextComponent;
    }

}
