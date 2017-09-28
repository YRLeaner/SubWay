package com.example.tyr.subway3.Service;

import android.view.SurfaceHolder;

import com.example.tyr.subway3.beans.VideoRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by tyr on 2017/8/16.
 */
public interface VideoService {
    @Headers("Cache-Control:public ,max-age=3600")
    @GET("v1/search")
    Call<VideoRoot> getVideos(@Query("num") String num,@Query("query") String query,@Query("start") String start);
}
