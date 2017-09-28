package com.example.tyr.subway3.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.tyr.subway3.ActivityAdapter.MusicActivityAdapter;

import com.example.tyr.subway3.R;

import com.example.tyr.subway3.Service.MusicService;
import com.example.tyr.subway3.Utils.RetrofitInit;


import com.example.tyr.subway3.beans.MainMusicRoot;


import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tyr on 2017/8/5.
 */
public class MusicActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DelegateAdapter delegateAdapter;
    List<DelegateAdapter.Adapter> adapters;
    LinearLayoutHelper layoutHelper2;
    MusicActivityAdapter myAdapter;
    private MainMusicRoot mainMusicRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_main);
        recyclerView = (RecyclerView)findViewById(R.id.music_main_recycler);

        Intent intent = getIntent();
        Bundle bundle  = intent.getExtras();
        String id = bundle.getString("musicid");

        MusicRextrofit(id);
        initVlayout();

    }

    private void initVlayout() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        delegateAdapter = new DelegateAdapter(layoutManager,false);

        recyclerView.setAdapter(delegateAdapter);
        adapters = new LinkedList<>();

        layoutHelper2 = new LinearLayoutHelper();
        //layoutHelper2.setAspectRatio(2.0f);
        //layoutHelper2.setDividerHeight(40);
        //layoutHelper2.setMargin(10, 30, 10, 10);
        layoutHelper2.setPadding(10, 30, 10, 10);


        myAdapter = new MusicActivityAdapter(this, layoutHelper2, 2, mainMusicRoot) {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400);
                holder.itemView.setLayoutParams(layoutParams);
            }
        };
        adapters.add(myAdapter);

        delegateAdapter.addAdapters(adapters);
        final Handler mainHandler = new Handler(Looper.getMainLooper());
        Runnable trigger = new Runnable() {
            @Override
            public void run() {
                recyclerView.requestLayout();
            }
        };
        mainHandler.postDelayed(trigger, 1000);
    }


    private void MusicRextrofit(String id){
        RetrofitInit retrofitInit = new RetrofitInit(this,"http://v3.wufazhuce.com:8000/api/");
        MusicService service = retrofitInit.initRetrofit().create(MusicService.class);
        Call<MainMusicRoot> repos = service.getMainMusic(id);
        repos.enqueue(new Callback<MainMusicRoot>() {
            @Override
            public void onResponse(Call<MainMusicRoot> call, Response<MainMusicRoot> response) {
                Log.d("gank", "succVideo");
                if (response.isSuccessful()) {
                    mainMusicRoot = response.body();
                    myAdapter.addAll(mainMusicRoot);
                }

            }

            @Override
            public void onFailure(Call<MainMusicRoot> call, Throwable t) {
                Log.d("gank", "failurefilm");
                Log.d("gank", t.toString());
            }
        });
    }

}
