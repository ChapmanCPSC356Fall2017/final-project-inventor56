package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/13/2017.
 */

public class Track {
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

    String getTrackName() {
        return this.name;
    }
    String getAlbumName() {
        return this.album.getName();
    }
}
