package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

import java.io.Serializable;

/**
 * Created by jsjos on 12/13/2017.
 */

@SuppressWarnings("serial")
public class TopTracks implements Serializable{
    public Track[] tracks;

    public String getTrackName(int ranking) {
        return tracks[ranking-1].getTrackName(); // Return name
    }

    public Track getTrack(int pos) {
        return tracks[pos];
    }

    public int getLength() {
        return tracks.length;
    }

}


