package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/12/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistInfo {
    //@SerializedName("artists")
    public Artist artists;
    public String getArtistID() {
        return artists.items[0].id; // Return the first artist found, since we limit our search to one artist
    }


}

class Artist {
    public String href;
    public Item[] items;
    public int limit;
    public String next;
    public int offset;
    public String previous;
    public int total;

}

class Item {
    public ExternalUrl external_urls;
    public Follower followers;
    public String[] genres;
    public String href;
    public String id;
    public Image[] images;
    public String name;
    public int popularity;
    public String type;
    public String uri;

}

class ExternalUrl {
    public String spotify;
}

class Follower {
    public String href;
    public int total;
}

class Image{
    public int height;
    public String url;
    public int width;
}
