package in.crazyvibes.retrofitviewmodellivedatadatabindingexample.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.R;
import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.databinding.MovieListItemBinding;
import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.ui.MovieActivity;
import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.ui.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.movie_list_item,parent,false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie=movieArrayList.get(position);
        holder.movieListItemBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieListItemBinding movieListItemBinding;
        public MovieViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());

            this.movieListItemBinding=movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=getAdapterPosition();

                    if(position!=RecyclerView.NO_POSITION) {

                        Movie selctedMovie = movieArrayList.get(position);

                        Intent intent=new Intent(context, MovieActivity.class);
                        intent.putExtra("movie",selctedMovie);
                        context.startActivity(intent);



                    }


                }
            });

        }
    }
}
