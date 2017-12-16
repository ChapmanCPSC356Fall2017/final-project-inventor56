package com.example.jsjos.topmusicdiscoveryapp.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.jsjos.topmusicdiscoveryapp.Fragments.SongFragment;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.TopTracks;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.Track;


public class SongPagerAdapter extends FragmentStatePagerAdapter {
    private final String LOGTAG = "Pager Adaper";

   private int num_pages; // We display the top ten, or less if none available

    // Here are all the tracks we'll be displaying
    private TopTracks myTracks;

    public SongPagerAdapter(FragmentManager fm, TopTracks tracksObj) {
        super(fm);
        myTracks = tracksObj;
        // Set length to be length of tracks
        num_pages = myTracks.getLength(); // Set how many pages we will be viewing

    }

    @Override
    public Fragment getItem(int position) {
        SongFragment frag = new SongFragment();
        Log.e(LOGTAG, "We made it here");

        Bundle b = new Bundle();
        b.putSerializable("TrackObj", myTracks.getTrack(position)); // Put in the specific track
        b.putInt("Ranking", position); // Ranking of track, no need to pass other tracks in this way

        frag.setArguments(b); // Set the arguments

        return frag;


    }

    @Override
    public int getCount() {
        return num_pages; // Ten Fragments
    }
}
