package com.example.popularmoviesstage2;

import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE_TITLE = "extra_movie_title";
    public static final String EXTRA_POSTER_PATH = "extra_poster_path";
    public static final String EXTRA_RELEASE_DATE = "extra_release_date";
    public static final String EXTRA_VOTE_AVERAGE = "extra_vote_average";
    public static final String EXTRA_OVERVIEW = "extra_overview";
    public static final String EXTRA_ID = "extra_id";

    ImageView poster;

    TextView title, releaseDate, voteAverage, overview;

    Button trailerButton;

    PopularMoviesAdapter adapter;

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

//        linking ImageViews and TextViews to activity_movie_details.xml

        poster = findViewById(R.id.movie_poster);

        title = findViewById(R.id.title);

        releaseDate = findViewById(R.id.release_date);

        voteAverage = findViewById(R.id.vote_average);

        overview = findViewById(R.id.overview);

//        extracting data from PopularMoviesActivity, and displaying it on activity_movie_details.xml on MovieDetailsActivity

        Intent intent = getIntent();

        String posterPath = intent.getStringExtra(EXTRA_POSTER_PATH);

        Picasso.get().load(posterPath).into(poster);

        String movieTitle = "Title: " + intent.getStringExtra(EXTRA_MOVIE_TITLE);

        title.setText(movieTitle);


        String movieReleaseDate = "Release Date: " + intent.getStringExtra(EXTRA_RELEASE_DATE);

        releaseDate.setText(movieReleaseDate);

        String movieVoteAverage = "Vote Average: " + intent.getStringExtra(EXTRA_VOTE_AVERAGE);

        voteAverage.setText(movieVoteAverage);

        String movieOverview = "Overview: \n" + intent.getStringExtra(EXTRA_OVERVIEW);

        overview.setText(movieOverview);

        String movieId = intent.getStringExtra(EXTRA_ID);

        Log.i("Pakistan", "Movie ID: " + movieId);
        callTrailerLink(movieId);

        trailerButton = findViewById(R.id.trailer_button);

        trailerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //String overview = adapter.getData().get(position).getOverview();

                String trailerKey = null ;
                String url = "http://www.youtube.com/watch?v=" + trailerKey ;

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }



    private void callTrailerLink(String movieId) {

        Retrofit retrofit3 = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi3 = retrofit3.create(JsonPlaceHolderApi.class);
        Call<TrailersResponse> call3 = jsonPlaceHolderApi3.getTrailers(movieId);
        call3.enqueue(new Callback<TrailersResponse>() {
            @Override
            public void onResponse(Call<TrailersResponse> call, Response<TrailersResponse> response) {
                Log.i("Pakistan", "" + response.body().trailersDataList.get(0).getKey());

            }

            @Override
            public void onFailure(Call<TrailersResponse> call, Throwable t) {

            }

        });
    }


}