package com.houssem.coemygrouphero.adapters;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.houssem.coemygrouphero.R;
import com.houssem.coemygrouphero.SuperHeroDetailsActivity;
import com.houssem.coemygrouphero.pojo.Hero;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HOUSSEM on 27/02/2016.
 */
public class SuperHeroListAdapter extends RecyclerView.Adapter<SuperHeroListAdapter.SuperHeroViewHolder>{

    private final List<Hero> heros;

    public SuperHeroListAdapter(List<Hero> heros)
    {
        this.heros = heros;
    }

    /**
     * Method to create viewHolder and inflate the view from an xml layout
     *
     * @param viewGroup
     * @param itemType
     * @return The viewHolder SuperHeroViewHolder
     */
    @Override
    public SuperHeroViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType)
    {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_card,viewGroup,false);
        return new SuperHeroViewHolder(view);
    }

    /**
     * Method to fill the cell with attributes from a hero object
     *
     * @param myViewHolder of type SuperHeroViewHolder
     * @param position of item in list
     */
    @Override
    public void onBindViewHolder(SuperHeroViewHolder myViewHolder, int position)
    {
        final  Hero hero = heros.get(position);
        myViewHolder.bind(hero);
    }

    @Override
    public int getItemCount() {
        return heros.size();
    }

    /**
     * The viewHolder class
     */
    public class SuperHeroViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView intro;
        private TextView year;
        private ImageView image;
        private ImageView seeMoreIcon;
        private View superHeroContent;
        private View superHeroContentCover;

        public SuperHeroViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            intro = (TextView) itemView.findViewById(R.id.intro);
            year = (TextView) itemView.findViewById(R.id.year);
            image = (ImageView) itemView.findViewById(R.id.image);
            seeMoreIcon = (ImageView) itemView.findViewById(R.id.see_more_icon);
            superHeroContent =  itemView.findViewById(R.id.super_hero_content);
            superHeroContentCover =  itemView.findViewById(R.id.super_hero_content_cover);
        }


        public void bind(final Hero aHero) {
            title.setTextColor(getTextColor(aHero.getColor()));
            title.setText(aHero.getTitle());
            year.setText(aHero.getYear());
            Picasso.with(image.getContext()).load(aHero.getImage()).centerCrop().fit().into(image);

            final GradientDrawable border = new GradientDrawable();
            border.setColor(0xFFFFFFFF); //white background
            border.setStroke(5, Color.parseColor(aHero.getColor()));
            border.setCornerRadius(15);
            superHeroContentCover.setBackground(getBackground(aHero.getColor()));
            superHeroContent.setBackground(border);
            seeMoreIcon.setImageResource(aHero.isFullIntroDisplayed() ? R.drawable.less : R.drawable.seemore);
            intro.setText(aHero.isFullIntroDisplayed() ? aHero.getIntro() : aHero.getShortIntro());
            seeMoreIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!aHero.isFullIntroDisplayed()) {
                        intro.setText(aHero.getIntro());
                        seeMoreIcon.setImageResource(R.drawable.less);
                    } else {
                        intro.setText(aHero.getShortIntro());
                        seeMoreIcon.setImageResource(R.drawable.seemore);
                    }

                    aHero.setFullIntroDisplayed(!aHero.isFullIntroDisplayed());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(v.getContext(), SuperHeroDetailsActivity.class);
                    intent.putExtra(SuperHeroDetailsActivity.HERO_EXTRA, aHero);
                    v.getContext().startActivity(intent);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return true;
                }
            });

        }

        private StateListDrawable getBackground(String color)
        {
            final StateListDrawable states = new StateListDrawable();
            final int yourBackgroundColor = Color.parseColor(color);
            states.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(yourBackgroundColor));
            states.addState(new int[]{android.R.attr.state_selected}, new ColorDrawable(yourBackgroundColor));
            return states;
        }

        private ColorStateList getTextColor(String color)
        {
            final int[][] states = new int[][] {
                    new int[] { android.R.attr.state_pressed},
                    new int[] {-android.R.attr.state_pressed}
            };

            final int[] colors = new int[] {
                    Color.WHITE,
                    Color.parseColor(color)
            };

            return new ColorStateList(states, colors);
        }
    }

}
