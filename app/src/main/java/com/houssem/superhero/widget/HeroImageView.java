package com.houssem.superhero.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by HOUSSEM on 29/02/2016.
 */
public class HeroImageView extends ImageView
{

    public HeroImageView(Context context)
    {
        super(context);
    }

    public HeroImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public HeroImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        final int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        final int height = (17 * parentWidth) / 15;

        setMeasuredDimension(parentWidth, height);
    }
}
