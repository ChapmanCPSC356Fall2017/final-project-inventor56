package com.example.jsjos.topmusicdiscoveryapp.Helper;

import android.util.Log;

import com.example.jsjos.topmusicdiscoveryapp.JSONObjects.AccessCredentials;
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
    private final String urlAuthorize = "https://accounts.spotify.com/api/token";

    private final String DEBUGTAG = "API Data Log";

    private String ResponseString = "null for the moment"; // This won't be set until a response comes in. Be Careful!

    public void Authenticate(final Callback call) throws Exception {

        Request request = new Request.Builder()
                .url(urlAuthorize)
                .addHeader("Authorization","Basic "+base64EncodedParam )
                .post(RequestBody.create(TEST_MEDIA_TYPE, grant_type))
                .build();

        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // Failure!
                ResponseString = "Failure!";
                call.onFailure(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseString = response.body().string();
                Log.e(DEBUGTAG, ResponseString);
                Gson gson = new Gson(); // JSON parser

                AccessCredentials authInfo = gson.fromJson(ResponseString, AccessCredentials.class); // Set authorization credentials
                call.onResult(authInfo); // Callback the results of the authentication API request
            }
        });
    }

    public interface Callback {
        void onFailure(Exception e); // From Stock API
        void onResult(AccessCredentials accessCred); // From Stock API
    }

}