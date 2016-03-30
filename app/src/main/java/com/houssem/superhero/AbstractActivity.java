package com.houssem.coemygrouphero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class AbstractActivity extends AppCompatActivity {

    protected static final String TAG = SuperHeroDetailsActivity.class.getName();

    public abstract int getLayoutResourceId();

    public abstract void findViews();

    public abstract void initializeUI();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResourceId());

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViews();
        initializeUI();
    }

}
