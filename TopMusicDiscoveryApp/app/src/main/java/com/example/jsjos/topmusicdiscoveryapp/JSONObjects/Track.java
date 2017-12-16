package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

import java.io.Serializable;

/**
 * Created by jsjos on 12/13/2017.
 */

@SuppressWarnings("serial")
public class Track implements Serializable {
    private Album album;
    private Artist[] artists;
    private String[] available_markets;
    private int disc_number;
    private int duration_ms;
    private String explicit;
    private ExternalId external_ids;
    private ExternalUrl external_urls;
    private String href;
    private String id;
    private String name;
    private int popularity;
    private String preview_url;
    private String track_number;
    private String type;
    private String uri;

    public String getTrackName() {
        return this.name;
    }
    public String getAlbumName() {
        return this.album.getName();
    }

    public Album retrieveAlbum() {
        return this.album;
    }

    public String getArtistNames() {
        boolean multipleArtists = false;
        StringBuilder totalArtistNames = new StringBuilder();
        int length = artists.length;
        if (length > 1)
            multipleArtists = true;
        for (int i = 0; i < length; i ++) {
            totalArtistNames.append(artists[i].getName());
            if(multipleArtists && i != length-1)
                totalArtistNames.append(", ");
        }
        return totalArtistNames.toString();
    }
}
