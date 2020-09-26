package com.example.popularmoviesstage2;

import com.google.gson.annotations.SerializedName;

public class Trailer {

    // extracting key (trailer youtube link) to add in intent after concatenating with youtube base url.

    @SerializedName("key")
    private String key;

    public String getKey() { return key; }
}
