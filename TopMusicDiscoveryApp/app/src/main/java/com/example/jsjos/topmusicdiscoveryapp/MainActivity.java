package com.example.jsjos.topmusicdiscoveryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public String client_id = "66311e9bfa0648fb8d29b41ce627f985"; // Your client id
    public String client_secret = "aaf1401b0acd4af19e8a22b26683cc1b"; // Your secret
    public String redirect_uri = "REDIRECT_URI"; // Your redirect uri

    private EditText searchBox;
    public String API_URL = "https://api.spotify.com/v1/search"; // URL for API

    public String artistName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API key

        this.searchBox = (EditText) findViewById(R.id.search_box);
    }

    public void OnClickSearch(View view) {
        artistName = searchBox.getText().toString();
        // Need to add + in between words of the String

        // Start the search via the API
        //SearchForData.execute();



    }

    class SearchForData extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {

        }

        protected String doInBackground(Void... urls) {
            try { // Try the API call here
                URL url = new URL(API_URL + "?q=" + artistName + "&type=artist");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    // Pass the JSON that is stringBuilder.toString() into a wrapper function that will get the artist ID from it
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("An error has occurred", e.getMessage(), e);
                return null;
            }
            return "MUST REPLACE THIS WITH THE JSON OBJECT YOU RETURN";
        }

        protected void onPostExecute(String resultResponse) {
            if(resultResponse == null) {
                Log.i("An error has occurred", resultResponse);
            }

            Log.i("We are done!", resultResponse);
        }
    }

}
