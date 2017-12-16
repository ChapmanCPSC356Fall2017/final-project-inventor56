package com.example.jsjos.topmusicdiscoveryapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.jsjos.topmusicdiscoveryapp.Fragments.SongFragment;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.TopTracks;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.Track;


public class SongPagerAdapter extends FragmentStatePagerAdapter {
    private final String LOGTAG = "Pager Adaper";

    private static final int NUM_PAGES = 10; // We display the top ten, fix later

    // Here are all the tracks we'll be displaying
    private TopTracks myTracks;

    public SongPagerAdapter(FragmentManager fm, TopTracks tracksObj) {
        super(fm);
        myTracks = tracksObj;
    }

    @Override
    public Fragment getItem(int position) {
        SongFragment frag = new SongFragment();
        Log.e(LOGTAG, "We made it here");
        return frag;


    }

    @Override
    public int getCount() {
        return NUM_PAGES; // Ten Fragments
    }
}
