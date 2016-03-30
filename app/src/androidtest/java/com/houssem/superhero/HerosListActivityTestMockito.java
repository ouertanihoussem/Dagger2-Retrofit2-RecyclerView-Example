package com.houssem.superhero;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.Matchers.is;


/**
 * Created by Formation on 22/03/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class HerosListActivityTestMockito {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getLayoutResourceIdTest(){
        HerosListActivity herosListActivity = mock(HerosListActivity.class);
        int resourceId = R.layout.activity_heros_list;
        when(herosListActivity.getLayoutResourceId()).thenReturn(resourceId);
        Assert.assertThat(herosListActivity.getLayoutResourceId(), is(resourceId));
    }

    @After
    public void tearDown() throws Exception {

    }
}