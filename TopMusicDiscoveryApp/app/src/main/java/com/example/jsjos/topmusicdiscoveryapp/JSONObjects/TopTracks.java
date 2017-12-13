package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/13/2017.
 */

public class TopTracks {
    public Track[] tracks;

    public String getTrackName(int ranking) {
        return tracks[ranking-1].getTrackName(); // Return name
    }

}


