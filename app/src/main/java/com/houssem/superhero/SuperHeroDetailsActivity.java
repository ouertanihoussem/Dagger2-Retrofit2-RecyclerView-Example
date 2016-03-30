package com.houssem.coemygrouphero;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.houssem.coemygrouphero.pojo.Hero;
import com.squareup.picasso.Picasso;

/**
 * Created by HOUSSEM on 27/02/2016.
 */
public class SuperHeroDetailsActivity extends AbstractActivity {

    public static final String HERO_EXTRA = "heroExtra";

    private TextView introTextView;
    private TextView bodyTextView;
    private ImageView imageView;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_super_hero_details;
    }

    @Override
    public void findViews() {
        introTextView = (TextView) findViewById(R.id.introTextView);
        bodyTextView = (TextView) findViewById(R.id.bodyTextView);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public void initializeUI(){
        final Hero hero = (Hero) getIntent().getExtras().getSerializable(SuperHeroDetailsActivity.HERO_EXTRA);

        if (hero!=null)
        {
            setTitle(hero.getTitle());
            introTextView.setText(hero.getIntro());
            bodyTextView.setText(hero.getText());
            Picasso.with(this)
                    .load(hero.getImage())
                    .centerCrop()
                    .fit()
                    .into(imageView);
        }
        else
        {
            Log.w(TAG, "Object passed in intent is null");
        }
    }

}
