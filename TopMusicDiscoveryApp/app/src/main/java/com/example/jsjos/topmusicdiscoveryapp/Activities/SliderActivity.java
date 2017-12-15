package com.example.jsjos.topmusicdiscoveryapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.jsjos.topmusicdiscoveryapp.Adapters.SongPagerAdapter;
import com.example.jsjos.topmusicdiscoveryapp.R;

/**
 * Created by jsjos on 12/14/2017.
 */

public class SliderActivity extends FragmentActivity {

    private ViewPager tPager;
    private PagerAdapter tPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_layout);

        tPager = (ViewPager) findViewById(R.id.view_pager);
        tPagerAdapter = new SongPagerAdapter(getSupportFragmentManager());
        tPager.setAdapter(tPagerAdapter);

    }

    public void onBackPressed() {
        super.onBackPressed(); // Call finish and go back
    }
}
