package com.example.jsjos.topmusicdiscoveryapp.JSONObjects;

/**
 * Created by jsjos on 12/12/2017.
 */

import com.google.gson.annotations.SerializedName;

public class AccessCredentials {
    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("expires_in")
    public int expiresIn;

    @SerializedName("scope")
    public String scope;
}
