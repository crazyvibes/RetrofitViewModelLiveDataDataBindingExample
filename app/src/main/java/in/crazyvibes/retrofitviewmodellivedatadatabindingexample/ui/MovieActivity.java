package in.crazyvibes.retrofitviewmodellivedatadatabindingexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;


import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.R;
import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.databinding.ActivityMovieBinding;
import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.ui.model.Movie;

public class MovieActivity extends AppCompatActivity {
    private Movie movie;
    private ActivityMovieBinding activityMovieBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activityMovieBinding= DataBindingUtil.setContentView(this,R.layout.activity_movie);
        Intent intent = getIntent();
        if (intent.hasExtra("movie")) {

            movie = getIntent().getParcelableExtra("movie");
            activityMovieBinding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle());


        }
    }
}