package com.example.tyr.subway3.Service;

import com.example.tyr.subway3.beans.SmileRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by tyr on 2017/8/5.
 */
public interface SmileService {
    @Headers("Cache-Control:public ,max-age=60")
    @GET("joke/content/text.from")
    Call<SmileRoot> getSmile(@Query("key") String key,
                             @Query("page") String page,@Query("pagesize") String pagesize);
}
