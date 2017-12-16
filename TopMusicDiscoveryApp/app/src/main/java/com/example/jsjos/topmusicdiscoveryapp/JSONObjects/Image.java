package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

import java.io.Serializable;

/**
 * Created by jsjos on 12/13/2017.
 */

@SuppressWarnings("serial")
public class Image implements Serializable{
    private int height;
    private String url;
    private int width;

    public String getUrl() {
        return this.url;
    }
}
