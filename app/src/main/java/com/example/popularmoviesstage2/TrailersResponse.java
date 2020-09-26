package com.example.popularmoviesstage2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailersResponse {

    @SerializedName("id")
    public int id;


    @SerializedName("results")
    public List<Trailer> trailersDataList;

}
