package com.houssem.superhero.dagger.modules;


import com.houssem.superhero.api.RetrofitSuperHeroImpl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Formation on 24/03/2016.
 */
@Module
public class ServiceCreatorModule {

    @Singleton
    @Provides
    public RetrofitSuperHeroImpl.SuperHeroService provideRetrofitService() {
        final OkHttpClient okClient = new OkHttpClient(); // client used to intercept request, response...
        okClient.interceptors().add(new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                com.squareup.okhttp.Response response = chain.proceed(chain.request());
                return response;
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitSuperHeroImpl.SuperHeroService.baseURL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RetrofitSuperHeroImpl.SuperHeroService.class);
    }

}
