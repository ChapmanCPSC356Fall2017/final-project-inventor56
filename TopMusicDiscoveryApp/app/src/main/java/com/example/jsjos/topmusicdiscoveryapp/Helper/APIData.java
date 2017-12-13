package com.example.jsjos.topmusicdiscoveryapp.Helper;

import android.util.Log;

import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.AccessCredentials;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.ArtistInfo;
import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.TopTracks;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by jsjos on 12/4/2017.
 */



public class APIData {

    public static final MediaType TEST_MEDIA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8" );

    // Given spotify keys for application
    private final String client_id = "66311e9bfa0648fb8d29b41ce627f985";
    private final String secret_id = "aaf1401b0acd4af19e8a22b26683cc1b";

    // May want to encode this in software later on, but should be workable for now
    private final String base64EncodedParam = "NjYzMTFlOWJmYTA2NDhmYjhkMjliNDFjZTYyN2Y5ODU6YWFmMTQwMWIwYWNkNGFmMTllOGEyMmIyNjY4M2NjMWI=";
    private final String grant_type = "grant_type=client_credentials";

    private final OkHttpClient client = new OkHttpClient();
    // URLs
    private final String urlAuthorize = "https://accounts.spotify.com/api/token";
    private final String urlSearchArtist = "https://api.spotify.com/v1/search";
    private final String urlSearchTopTen = "https://api.spotify.com/v1/artists/";


    private final String DEBUGTAG = "API Data Log";

    //private String ResponseString = "null for the moment"; // This won't be set until a response comes in. Be Careful!

    public void Authenticate(final AuthorizationCallback call) throws Exception {

        Request request = new Request.Builder()
                .url(urlAuthorize)
                .addHeader("Authorization","Basic "+base64EncodedParam )
                .post(RequestBody.create(TEST_MEDIA_TYPE, grant_type))
                .build();

        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // Failure!
                //ResponseString = "Failure!";
                call.onFailure(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //ResponseString = response.body().string();
                //Log.e(DEBUGTAG, ResponseString);

                Gson gson = new Gson(); // JSON parser

                AccessCredentials authInfo = gson.fromJson(response.body().string(), AccessCredentials.class); // Set authorization credentials
                call.onResult(authInfo); // Callback the results of the authentication API request
            }
        });
    }
    public void SearchForArtists(String artistName, String authorization, final ArtistSearchCallback call) throws Exception {

        Request request = new Request.Builder()
                .url(urlSearchArtist+"?q="+artistName+"&type=artist&limit=1") // Url with artist name, limit to first result
                .addHeader("Authorization","Bearer "+authorization )
                .build();

        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // Failure! Could not find artist
                //ResponseString = "Failure!";
                call.onFailure(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //String ResponseString = response.body().string();
                //Log.e(DEBUGTAG, ResponseString);
                Gson gson = new Gson(); // JSON parser

                ArtistInfo artistInfo = gson.fromJson(response.body().string(), ArtistInfo.class);
                call.onResult(artistInfo); // Callback the results of the artist search
            }
        });
    }

    public void SearchForTopTen(String artistID, String authorization, final TopTenCallback call) throws Exception {

        Request request = new Request.Builder()
                .url(urlSearchTopTen+artistID+"/top-tracks?country=US") // Url with artistID. Returns 10 results
                .addHeader("Authorization","Bearer "+authorization )
                .build();

        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // Failure! Could not find top ten tracks!
                //ResponseString = "Failure!";
                call.onFailure(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //String ResponseString = response.body().string();
                //Log.e(DEBUGTAG, ResponseString);
                Gson gson = new Gson(); // JSON parser

                TopTracks tracks = gson.fromJson(response.body().string(), TopTracks.class);
                call.onResult(tracks); // Callback the results of the top ten tracks search
            }
        });
    }


    public interface AuthorizationCallback {
        void onFailure(Exception e); // From Stock API
        void onResult(AccessCredentials accessCred); // From Stock API
    }
    public interface ArtistSearchCallback {
        void onFailure(Exception e); // From Stock API
        void onResult(ArtistInfo artist); // From Stock API
    }
    public interface TopTenCallback {
        void onFailure(Exception e); // From Stock API
        void onResult(TopTracks topTen); // From Stock API
    }

}