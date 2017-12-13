package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/12/2017.
 */

public class ArtistInfo {
    //@SerializedName("artists")
    public ArtistSV artists;
    public String getArtistID() {
        return artists.getItem(0).getId(); // Return the first artist found, since we limit our search to one artist
    }


}

class ArtistSV {
    private String href;
    private Item[] items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;

    Item getItem(int index) {
        return this.items[index];
    }

}

class Item {
    private ExternalUrl external_urls;
    private Follower followers;
    private String[] genres;
    private String href;
    private String id;
    private Image[] images;
    private String name;
    private int popularity;
    private String type;
    private String uri;

    String getId() {
        return this.id;
    }

}

class Follower {
    private String href;
    private int total;
}
