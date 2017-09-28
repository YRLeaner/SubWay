package com.example.tyr.subway3.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import com.example.tyr.subway3.ActivityAdapter.VideoActivityAdapter;
import com.example.tyr.subway3.MainActivity;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Service.FilmService;
import com.example.tyr.subway3.Utils.BlurTransformation;
import com.example.tyr.subway3.Utils.RetrofitInit;
import com.example.tyr.subway3.beans.MainFilmRoot;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tyr on 2017/8/7.
 */
public class FilmActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DelegateAdapter delegateAdapter;
    List<DelegateAdapter.Adapter> adapters;
    LinearLayoutHelper layoutHelper2;
    VideoActivityAdapter myAdapter;
    MainFilmRoot mainFilmRoot;
    FrameLayout frameLayout;
    Target target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_main);
        recyclerView = (RecyclerView)findViewById(R.id.film_main_recycler);
        frameLayout = (FrameLayout)findViewById(R.id.film_main_frame);
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        String filmid = bundle.getString("filmid");

        FilmRetrofi(filmid);

        initLayout();

}

    private void initLayout() {

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
        layoutHelper2.setDividerHeight(20);
        //layoutHelper2.setMargin(10, 30, 10, 10);
        layoutHelper2.setPadding(10, 30, 10, 10);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Picasso.with(FilmActivity.this).resumeTag("filmpica");
                }else {
                    Picasso.with(FilmActivity.this).pauseTag("filmpica");
                }

            }
        });

        myAdapter = new VideoActivityAdapter(this, layoutHelper2, 2, mainFilmRoot) {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
               if (position==0){
                   VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                   holder.itemView.setLayoutParams(layoutParams);
               }else {
                   VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                   holder.itemView.setLayoutParams(layoutParams);
               }
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


        target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                frameLayout.setBackground(new BitmapDrawable(getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable drawable) {

            }

            @Override
            public void onPrepareLoad(Drawable drawable) {

            }
        };
    }

    private void FilmRetrofi(String id){
        RetrofitInit retrofitInit = new RetrofitInit(this,"http://api.douban.com/");
        FilmService service = retrofitInit.initRetrofit().create(FilmService.class);
        Call<MainFilmRoot> repos = service.getFilmItem(id);
        repos.enqueue(new Callback<MainFilmRoot>() {
            @Override
            public void onResponse(Call<MainFilmRoot> call, Response<MainFilmRoot> response) {
                Log.d("gank", "succVideo");
                if (response.isSuccessful()) {
                    mainFilmRoot = response.body();
                    Message handleMsg = new Message();
                    handleMsg.what = 2;
                    updateChatHandler.sendMessage(handleMsg);
                    myAdapter.addAll(mainFilmRoot);
                }

            }

            @Override
            public void onFailure(Call<MainFilmRoot> call, Throwable t) {
                Log.d("gank", "failurefilm");
                Log.d("gank", t.toString());
            }
        });
    }

    Handler updateChatHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    break;
                case 2:
                    Picasso.with(FilmActivity.this).load(mainFilmRoot.getImages().getLarge()).transform(new BlurTransformation(FilmActivity.this)).into(target);
                    break;
            }
            super.handleMessage(msg);
        }
    };



}








