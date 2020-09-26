package com.example.popularmoviesstage2;

import android.util.Log;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
// API calls are made here for Popular and Top Rated movies.

    String apiKey = "56e13caa83283369bdc35dba762d6723";
    String MOVIE_ID = "extra_movie";




    @GET(("movie/popular?api_key=" + apiKey))
    Call<MovieResponse> getPopular();

    @GET(("movie/top_rated?api_key=" + apiKey))
    Call<MovieResponse> getTopRated();


    // stage 2 api call for trailers.

    @GET(("movie/{movie}/videos?api_key=" + apiKey))
    Call<TrailersResponse> getTrailers(@Path("movie") String movieId);


//Call<List<Repo>> listRepos(@Path("user") String user);

    // stage 2 api call for reviews.

    @GET(("movie/" + MOVIE_ID +"reviews?api_key=" + apiKey))
    Call<MovieResponse> getReviews();

}
