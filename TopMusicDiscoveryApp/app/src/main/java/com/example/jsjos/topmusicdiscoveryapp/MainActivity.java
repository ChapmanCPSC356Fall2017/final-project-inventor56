package com.example.jsjos.topmusicdiscoveryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.jsjos.topmusicdiscoveryapp.Helper.APIData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String LOGTAG = "blah";

    private EditText searchBox;
    public String API_URL = "https://api.spotify.com/v1/search"; // URL for API

    public String artistName;

    APIData api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API key

        this.searchBox = (EditText) findViewById(R.id.search_box);

        // Setup API class
        api = new APIData();
    }

    public void OnClickSearch(View view) throws Exception {
        // Format user's search request so that it can be entered into the GET request
        String unformattedString = searchBox.getText().toString();
        // Need to add + in between words of the String
        String ArtistName = unformattedString.replaceAll("\\s","+"); // Replace all whitespace with +
        // Start the search via the API
        //SearchForData.execute();

        String test = api.Authenticate();
        Log.e(LOGTAG, test);

    }



}
