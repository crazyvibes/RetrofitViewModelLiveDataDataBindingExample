package in.crazyvibes.retrofitviewmodellivedatadatabindingexample.ui.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.data.repository.MovieRepository;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        movieRepository=new MovieRepository(application);
    }

    public LiveData<List<Movie>> getAllMovies(){

        return movieRepository.getMutableLiveData();
    }
}
