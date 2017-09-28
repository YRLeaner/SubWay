package com.example.tyr.subway3.Service;

import com.example.tyr.subway3.beans.MainMusicRoot;
import com.example.tyr.subway3.beans.MusicRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by tyr on 2017/8/18.
 */
public interface MusicService {
    @Headers("Cache-Control:public ,max-age=3600")
    @GET("channel/music/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Call<MusicRoot> getMusic();

    @GET("music/detail/{id}?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Call<MainMusicRoot> getMainMusic(@Path("id") String id);
}
