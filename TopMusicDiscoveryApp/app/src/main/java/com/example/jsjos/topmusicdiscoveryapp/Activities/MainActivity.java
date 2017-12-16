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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.jsjos.topmusicdiscoveryapp.Helper.APIData;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.AccessCredentials;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.ArtistInfo;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.TopTracks;
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


    // Widgets
    private EditText searchBox;
    private ProgressBar loadingBar;
    private Button searchButton;


    public String artistName;

    // Access Credentials Object
    private AccessCredentials authorizationInfo;

    //Artist Info Object
    private ArtistInfo artistInfoObj;

    //Top Ten Tracks Object
    private TopTracks topTenTracksObj;
    // Boolean to check if app has already been authorized
    private boolean accessCredAttained;

    APIData api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API key
        this.searchBox = (EditText) findViewById(R.id.search_box);

        //Set loading bar and button
        this.loadingBar = (ProgressBar) findViewById(R.id.loading_wheel);
        this.searchButton = (Button) findViewById(R.id.search_button);

        // First run, so we don't have the credentials yet (Spotify needs to authorize API request first)
        accessCredAttained = false;

        // Setup API class
        api = new APIData();
    }

    private void toggleLoading(boolean toggleOn) {
        loadingBar.setVisibility(toggleOn ? View.VISIBLE : View.INVISIBLE);
        searchButton.setVisibility(toggleOn ? View.INVISIBLE : View.VISIBLE);
    }

    public void OnClickSearch(View view) throws Exception {
        // Format user's search request so that it can be entered into the GET request
        String unformattedString = searchBox.getText().toString();
        // Need to add + in between words of the String
        //String ArtistName = unformattedString.replaceAll("\\s","+"); // Replace all whitespace with +
        String ArtistName = URLEncoder.encode(unformattedString, "UTF-8");

        //Turn on loading wheel
        toggleLoading(true);

        //Search
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
                try {
                    Log.e(LOGTAG, "Artist is " + artist.getArtistID());
                    artistInfoObj = artist; // Set artist info object
                    SearchForTracks(artistInfoObj.getArtistID());
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleLoading(false); // Toggle loading bar
                            searchBox.getText().clear(); // Clear text
                            searchBox.setHint("Invalid Artist! Please try again"); // Display error
                        }
                    });
                }
            }
        });
    }

    public void SearchForTracks (String artistID) throws Exception {
        api.SearchForTopTen(artistID, authorizationInfo.accessToken, new APIData.TopTenCallback() {
            @Override
            public void onFailure(Exception e) {
                Log.e(LOGTAG, "Failure here");
            }

            @Override
            public void onResult(TopTracks topTenTracks) {
                try {
                    int rank = 1;
                    Log.e(LOGTAG, "Song at #" + rank + " is " + topTenTracks.getTrackName(rank));
                    topTenTracksObj = topTenTracks; // Set top Ten Tracks Object

                    // Prepare to show your results
                    Intent i = new Intent(MainActivity.this, SliderActivity.class);
                    i.putExtra("TracksObject", topTenTracksObj);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleLoading(false);
                        }
                    });

                    /////////////////////
                    // Start View Pager!
                    /////////////////////
                    startActivity(i);

                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleLoading(false); // Toggle loading bar
                            searchBox.getText().clear(); // Clear text
                            searchBox.setHint("App Error! Please enter a different artist's name"); // Display error
                        }
                    });
                }
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
                    try {
                        // Store here
                        Log.e(LOGTAG, "Successful Callback!");
                        authorizationInfo = accessCred; //  Set the authorization details to what was returned in the callback
                        accessCredAttained = true;
                        SearchForSongs(artist);
                        Log.e(LOGTAG, authorizationInfo.accessToken);
                    } catch (Exception e) {
                        e.printStackTrace();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                toggleLoading(false); // Toggle loading bar
                                searchBox.getText().clear(); // Clear text
                                searchBox.setHint("Authentication error (Spotify server may be down). Try again"); // Display error
                            }
                        });
                    }
                }
            }); // Authenticate with server;
        }
        else {
            // Start your search for songs in case you already have an authentication key
            SearchForSongs(artist); }
    }
}
