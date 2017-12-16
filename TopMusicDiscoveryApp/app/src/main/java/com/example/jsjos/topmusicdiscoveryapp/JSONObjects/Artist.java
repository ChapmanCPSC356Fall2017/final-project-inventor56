package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

import java.io.Serializable;

/**
 * Created by jsjos on 12/13/2017.
 */

@SuppressWarnings("serial")
public class Artist implements Serializable{
    private ExternalUrl external_urls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;
}
