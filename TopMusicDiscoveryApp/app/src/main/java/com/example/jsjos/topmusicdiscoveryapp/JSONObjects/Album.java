package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/13/2017.
 */

public class Album {
    private String album_type;
    private Artist[] artists;
    private String[] available_markets;
    private ExternalUrl external_urls;
    private String href;
    private String id;
    private Image[] images;
    private String name;
    private String type;
    private String uri;

    String getName() {
        return this.name;
    }
}
