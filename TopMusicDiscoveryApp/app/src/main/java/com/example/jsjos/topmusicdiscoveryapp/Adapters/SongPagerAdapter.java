package com.example.jsjos.topmusicdiscoveryapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jsjos.topmusicdiscoveryapp.Fragments.SongFragment;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.TopTracks;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.Track;

/**
 * Created by jsjos on 12/14/2017.
 */



public class SongPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 10; // We display the top ten, fix later
    private TopTracks[] myTracks;

    public SongPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        SongFragment frag = new SongFragment();

        return frag;


    }

    public int getCount() {
        return NUM_PAGES; // Ten Fragments
    }
}
