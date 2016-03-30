package com.houssem.superhero;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Formation on 22/03/2016.
 */
@RunWith(AndroidJUnit4.class)
public class HerosListActivityTestEspresso {

    private String validTitle;

    @Rule
    public ActivityTestRule<HerosListActivity> mActivityRule = new ActivityTestRule<>(
            HerosListActivity.class);

    @Before
    public void initValidTitle(){
        validTitle = InstrumentationRegistry.getTargetContext()
                .getString(R.string.marvel);
    }

    @Test
    public void changeActivityOnHerosListItemClick() {
        onView(withId(R.id.heros)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        Intents.init();
        mActivityRule.launchActivity(new Intent(InstrumentationRegistry.getTargetContext(), SuperHeroDetailsActivity.class));
        Intents.release();

    }

    @Test
    public void checkTitleDisplayed(){
        matchToolbarTitle(validTitle);
    }

    private static ViewInteraction matchToolbarTitle(String title) {
        return onView(allOf((isAssignableFrom(TextView.class)), withParent(isAssignableFrom(Toolbar.class)))).check(matches(withText(title)));
    }

}
