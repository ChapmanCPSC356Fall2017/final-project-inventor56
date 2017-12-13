package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/13/2017.
 */

import com.google.gson.annotations.SerializedName;

public class TopTracks {
    public Track[] tracks;

    public String getTrackName(int ranking) {
        return tracks[ranking+1].name; // Return name
    }

}

class Track {
    public Album album;
    public ArtistT[] artists;
    public String[] available_markets;
    public int disc_number;
    public int duration_ms;
    public String explicit;
    public ExternalId external_ids;
    public ExternalUrl external_urls;
    public String href;
    public String id;
    public String name;
    public int popularity;
    public String preview_url;
    public String track_number;
    public String type;
    public String uri;

}

class Album {
    public String album_type;
    public ArtistT[] artists;
    public String[] available_markets;
    public ExternalUrl external_urls;
    public String href;
    public String id;
    public Image[] images;
    public String name;
    public String type;
    public String uri;
}

class ArtistT {
    public ExternalUrl external_urls;
    public String href;
    public String id;
    public String name;
    public String type;
    public String uri;

}

class ExternalId {
    public String isrc;
}
