package com.example.jsjos.topmusicdiscoveryapp.Activities;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.jsjos.topmusicdiscoveryapp.Helper.APIData;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.AccessCredentials;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.ArtistInfo;
import com.example.jsjos.topmusicdiscoveryapp.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private final String LOGTAG = "main_activity_class";

    // Extra strings
    private static final String ACCESS_EXTRA = "access tester";
    private final String TOKEN_EXTRA = "token tester";
    private final String EXPIRE_EXTRA = "expire tester";
    private final String STATE_EXTRA = "state tester";

    private EditText searchBox;
    public String API_URL = "https://api.spotify.com/v1/search"; // URL for API

    public String artistName;

    // Access Credentials Object
    private AccessCredentials authorizationInfo;
    // Boolean to check if app has already been authorized
    private boolean accessCredAttained;

    APIData api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API key
        this.searchBox = (EditText) findViewById(R.id.search_box);

        // First run, so we don't have the credentials yet (Spotify needs to authorize API request first)
        accessCredAttained = false;

        // Setup API class
        api = new APIData();
    }

    public void OnClickSearch(View view) throws Exception {
        // Format user's search request so that it can be entered into the GET request
        String unformattedString = searchBox.getText().toString();
        // Need to add + in between words of the String
        //String ArtistName = unformattedString.replaceAll("\\s","+"); // Replace all whitespace with +
        String ArtistName = URLEncoder.encode(unformattedString, "UTF-8");

        GetAccessTokens(ArtistName);

        //SearchForSongs(ArtistName); // Could be error here....
        Log.e(LOGTAG, "This runs first");

    }

    public void SearchForSongs (String artist) throws Exception {
        api.SearchForArtists(artist, authorizationInfo.accessToken, new APIData.ArtistSearchCallback() {
            @Override
            public void onFailure(Exception e) {
                Log.e(LOGTAG, "Failure here");
            }

            @Override
            public void onResult(ArtistInfo artist) {
                Log.e(LOGTAG, "Artist is " + artist.ArtistID);
            }
        });
    }

    public void GetAccessTokens(final String artist) throws Exception {


        if (!accessCredAttained){
            api.Authenticate(new APIData.AuthorizationCallback() {
                @Override
                public void onFailure(Exception e) {
                    Log.e(LOGTAG, "Failure here");

                }

                @Override
                public void onResult(AccessCredentials accessCred) {
                    // Store here
                    Log.e(LOGTAG, "Successful Callback!");
                    authorizationInfo = accessCred; //  Set the authorization details to what was returned in the callback
                    accessCredAttained = true;
                    //SearchForSongs(artist);

                    Log.e(LOGTAG, authorizationInfo.accessToken);
                }
            }); // Authenticate with server;
        }
        else {
            SearchForSongs(artist); }

    }



}
