package com.example.popularmoviesstage2;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//This is a test comment

//This is a test comment2

//This is a test comment3


public class TrailersResponse {

    @SerializedName("id")
    public int id;


    @SerializedName("results")
    public List<Trailer> trailersDataList;

}
