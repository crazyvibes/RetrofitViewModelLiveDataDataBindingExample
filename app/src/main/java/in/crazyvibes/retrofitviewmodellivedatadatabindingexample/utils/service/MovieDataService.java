package in.crazyvibes.retrofitviewmodellivedatadatabindingexample.utils.service;

import in.crazyvibes.retrofitviewmodellivedatadatabindingexample.data.remote.MovieDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {


    @GET("movie/popular")
    Call<MovieDBResponse> getPopularMovies(@Query("api_key") String apiKey);


}
