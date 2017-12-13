package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/12/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistInfo {
    @SerializedName("artists")
    public Artist artists;
    //public String ArtistID;

}

class Artist {
    public String href;
    public List<Item> items;
}

class Item {
    public ExternalUrl external_url;
    public List<Genre> genres;
    public String href;

}

class ExternalUrl {
    public String spotify;
}

class Genre {

}

class Images {
    public int height;
    public String url;
    public int width;
}
