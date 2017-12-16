package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

import java.io.Serializable;

/**
 * Created by jsjos on 12/13/2017.
 */

@SuppressWarnings("serial")
public class Album implements Serializable{
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

    public Image getFirstImage() { // Return the images for this album
        return this.images[0]; // Just return the first loaded image (640x640), only need one photo
    }
}
