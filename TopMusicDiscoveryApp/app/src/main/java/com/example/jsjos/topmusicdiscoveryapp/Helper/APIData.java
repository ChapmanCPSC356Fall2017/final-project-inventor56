package com.example.jsjos.topmusicdiscoveryapp.Helper;

import android.util.Log;

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

    private final String client_id = "66311e9bfa0648fb8d29b41ce627f985";
    private final String secret_id = "aaf1401b0acd4af19e8a22b26683cc1b";
    private final String grant_type = "client_credentials";

    private final OkHttpClient client = new OkHttpClient();
    private final String urlAuthorize = "https://accounts.spotify.com/api/token";

    private final String DEBUGTAG = "API Data Log";

    private String ResponseString; // This won't be set until a response comes in. Be Careful!

    public String Authenticate() throws Exception {

        Request request = new Request.Builder()
                .url(urlAuthorize)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // Failure!
                ResponseString = "Failure!";
            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseString = response.body().string();
            }
        });
        //Log.d(DEBUGTAG, responseConverted[0]);

        //return responseConverted[0]; // return response
        return ResponseString; // return response
    }


}
