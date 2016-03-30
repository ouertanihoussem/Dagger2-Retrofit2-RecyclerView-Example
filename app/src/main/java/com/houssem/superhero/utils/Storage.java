package com.houssem.coemygrouphero.utils;

/**
 * Created by Formation on 25/03/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.houssem.coemygrouphero.dagger.Application;

import javax.inject.Inject;

/**
 * Class to save login and password in sharedPreferences
 */
public class Storage {
    protected final String SHARED_PREFERENCES = "StorageModule";
    protected final String PREFERENCES_LOGIN_KEY = "PREFERENCES_LOGIN_KEY";
    protected final String PREFERENCES_PASSWORD_KEY = "PREFERENCES_PASSWORD_KEY";

    @Inject
    Context context;

    SharedPreferences sharedPreferences;

    public Storage() {
        Application.app().getContextComponent().inject(this);
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, context.MODE_PRIVATE);
    }

    public String getLoginKey() {
        return this.sharedPreferences.getString(PREFERENCES_LOGIN_KEY, null);
    }
    public String getPasswordKey() {
        return this.sharedPreferences.getString(PREFERENCES_PASSWORD_KEY, null);
    }

    public void setLoginKey(String loginKey) {
        this.sharedPreferences.edit().putString(PREFERENCES_LOGIN_KEY, loginKey).apply();
    }

    public void setPasswordKey(String passwordKey) {
        this.sharedPreferences.edit().putString(PREFERENCES_PASSWORD_KEY, passwordKey).apply();
    }
}
