package com.example.tyr.subway3.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tyr.subway3.FragmentAdapter.FilmsRecyclerViewAdapter;
import com.example.tyr.subway3.MainApplication;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Service.FilmService;
import com.example.tyr.subway3.Utils.NetWorkUtils;
import com.example.tyr.subway3.Utils.RetrofitInit;
import com.example.tyr.subway3.activity.FilmActivity;
import com.example.tyr.subway3.beans.FilmRoot;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class XFilmFragment extends BaseFragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private List<FilmRoot.Subjects> filmRoots;
    private Context context;
    private FilmsRecyclerViewAdapter adapter;
    @BindView(R.id.film_recyclerView)
    AnimRFRecyclerView mRecyclerView;

    private View headerView;
    private View footerView;
    private List<String> datas;
    private Handler mHandler = new Handler();
    int[] like = new int[6];
    SharedPreferences sharedPreferences;
    private StringBuilder likeStr;
    String[] string = {"爱情", "喜剧", "古装", "科幻", "恐怖", "悬疑"};
    MainApplication mainApplication;
    FraToActAnimListener fraToActAnimListener;
    LoadService loadService;
    public void setFraToActAnimListener(FraToActAnimListener fraToActAnimListener) {
        this.fraToActAnimListener = fraToActAnimListener;
    }

    public static XFilmFragment newInstance() {
        return new XFilmFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.film_fragment, container, false);
        ButterKnife.bind(this, rootView);
        loadService = LoadSir.getDefault().register(rootView, new com.kingja.loadsir.callback.Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                if (NetWorkUtils.isConnectedByState(getActivity())){
                    loadService.showSuccess();
                }

            }
        });
        return NetWorkUtils.isConnectedByState(getActivity())==true?rootView:loadService.getLoadLayout();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainApplication = (MainApplication)getActivity().getApplicationContext();
        filmRoots = new ArrayList<>();
        context =getActivity();
        initRecycelr();
        initDate();

        initRetro("0", "5");
        //FilmRetrofi();
    }

    private void initDate() {
        Log.d("gank","shared");
        likeStr = new StringBuilder();
        sharedPreferences = getActivity().getSharedPreferences("filmlike", getActivity().MODE_PRIVATE);
        like[0] = sharedPreferences.getInt("爱情", 0);
        like[1] = sharedPreferences.getInt("喜剧", 0);
        like[2] = sharedPreferences.getInt("古装",0);
        like[3] = sharedPreferences.getInt("科幻",0);
        like[4] = sharedPreferences.getInt("恐怖",0);
        like[5] = sharedPreferences.getInt("悬疑",0);


        for (int i=0;i<6;i++){
            if (like[i]==1){
                likeStr.append(string[i]);
                Log.d("gank",likeStr.toString());
            }
        }

        if (likeStr.toString().equals(" ")){
            likeStr.append("喜剧");
        }
        Log.d("gank", likeStr.toString());
    }


    Handler updateChatHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    loadMoreComplate();
                    mRecyclerView.loadMoreComplate();
                    break;
                case 2:
                    loadMoreComplate();
                    mRecyclerView.loadMoreComplate();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void initRetro(String start,String count){
        Log.d("gank","jiazai");

        RetrofitInit init = new RetrofitInit(getActivity(),"http://api.douban.com/");
        FilmService filmService = init.initRetrofit().create(FilmService.class);
        Call<FilmRoot> repos = filmService.getFilm(likeStr.toString(),start,count);
        repos.enqueue(new Callback<FilmRoot>() {
            @Override
            public void onResponse(Call<FilmRoot> call, Response<FilmRoot> response) {
                Log.d("gank", "succVideo");
                if (response.isSuccessful()) {
                    FilmRoot result = response.body();
                    List<FilmRoot.Subjects> resultses = result.getSubjects();
                    adapter.addAll(resultses);
                    Message handleMsg = new Message();
                    handleMsg.what = 1;
                    updateChatHandler.sendMessage(handleMsg);
                }

            }

            @Override
            public void onFailure(Call<FilmRoot> call, Throwable t) {
                Log.d("gank", "failureVideo");
                Log.d("gank", t.toString());
            }
        });
    }

    private void initRecycelr(){
        //headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_view,null);
        footerView = LayoutInflater.from(getActivity()).inflate(R.layout.footer_view,null);
        //mRecyclerView.addHeaderView(headerView);
        mRecyclerView.addFootView(footerView);
        adapter = new FilmsRecyclerViewAdapter(filmRoots,context);
        adapter.setOnItemClickListener(new OnMyItemClickListener() {
            @Override
            public void itemClick(View v, int position) {
                Toast.makeText(context, "hah", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FilmActivity.class);
                intent.putExtra("filmid", filmRoots.get(position).getId());
                if (fraToActAnimListener!=null){
                    fraToActAnimListener.beginToAnim(intent,v);
                }
                //startActivity(intent);

            }
        });

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new AnimRFLinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);
        //mRecyclerView.setHeaderImageDurationMillis(300);
        //mRecyclerView.setHeaderImageMinAlpha(0.6f);
        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadDataListener(new AnimRFRecyclerView.LoadDataListener() {
            @Override
            public void onRefresh() {
                new Thread(new MyRunnable(true)).start();
            }

            @Override
            public void onLoadMore() {
                new Thread(new MyRunnable(false)).start();
            }
        });
        mRecyclerView.setRefreshEnable(false);
        //mRecyclerView.setRefresh(false);
        //setup materialviewpager

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Picasso.with(getActivity()).resumeTag("filmPicassico");
                }else {
                    Picasso.with(getActivity()).pauseTag("filmPicassico");
                }

            }
        });
    }


    class MyRunnable implements Runnable {
        boolean isRefresh;
        public MyRunnable(boolean isRefresh) {
            this.isRefresh = isRefresh;
        }
        @Override
        public void run() {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRefresh) {
                        //newData();
                        Log.d("re", "刷新");
                      /*  refreshComplate();
                        // 刷新完成后调用，必须在UI线程中
                        mRecyclerView.refreshComplate();*/
                    } else {
                        //addData();
                        Log.d("re", "刷新2");
                        int start = mainApplication.getFilm_start();
                        mainApplication.setFilm_start(start+5);
                        initRetro(String.valueOf(start+5), "5");
                        //loadMoreComplate();

                        // 加载更多完成后调用，必须在UI线程中
                        Message handleMsg = new Message();
                        handleMsg.what = 2;
                        updateChatHandler.sendMessage(handleMsg);

                    }
                }
            }, 2000);
        }
    }

    public void refreshComplate() {
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    public void loadMoreComplate() {
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

}


