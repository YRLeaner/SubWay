package com.example.tyr.subway3.Service;

import com.example.tyr.subway3.beans.FilmRoot;
import com.example.tyr.subway3.beans.MainFilmRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tyr on 2017/8/5.
 */
public interface FilmService {
    @Headers("Cache-Control:public ,max-age=3600")
    @GET("v2/movie/search")
    Call<FilmRoot> getFilm(@Query("tag") String tag, @Query("start") String start,@Query("count") String count);


    @GET("v2/movie/subject/{id}")
    Call<MainFilmRoot> getFilmItem(@Path("id") String id);
}
