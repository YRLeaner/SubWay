package com.example.tyr.subway3.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.tyr.subway3.FragmentAdapter.BooksRecyclerViewAdapter;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Service.MusicService;
import com.example.tyr.subway3.Utils.NetWorkUtils;
import com.example.tyr.subway3.Utils.RetrofitInit;
import com.example.tyr.subway3.activity.MusicActivity;
import com.example.tyr.subway3.beans.MusicRoot;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class XNewsFragment extends BaseFragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private List<MusicRoot.Data> musicRoots;
    private Context context;
    private BooksRecyclerViewAdapter adapter;

    @BindView(R.id.news_recyclerView)
    AnimRFRecyclerView mRecyclerView;

    private View headerView;
    private View footerView;
    private Handler mHandler = new Handler();

    LoadService loadService;
    public static XNewsFragment newInstance() {
        return new XNewsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.books_fragment, container, false);
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


        musicRoots = new ArrayList<>();
        context =getActivity();
        initLayout();
        //MusicRetrofi();
        initMusicRetrofit();
    }

    private void initLayout() {

        footerView = LayoutInflater.from(getActivity()).inflate(R.layout.footer_view,null);
        //mRecyclerView.addHeaderView(headerView);
        mRecyclerView.addFootView(footerView);
        adapter = new BooksRecyclerViewAdapter(musicRoots,context);
        adapter.setOnItemClickListener(new OnMyItemClickListener() {
            @Override
            public void itemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), MusicActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("musicid", musicRoots.get(position).getItem_id());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new AnimRFLinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

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
        //setup materialviewpager
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
                        Log.d("re","刷新");
                        refreshComplate();
                        // 刷新完成后调用，必须在UI线程中
                        mRecyclerView.refreshComplate();
                    } else {
                        //addData();
                        Log.d("re","刷新2");
                        initMusicRetrofit();
                        //loadMoreComplate();
                        // 加载更多完成后调用，必须在UI线程中
                       // mRecyclerView.loadMoreComplate();
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

    private void initMusicRetrofit() {
        RetrofitInit init = new RetrofitInit(getActivity(),"http://v3.wufazhuce.com:8000/api/");
        MusicService service = init.initRetrofit().create(MusicService.class);
        Call<MusicRoot> repos = service.getMusic();
        repos.enqueue(new Callback<MusicRoot>() {
            @Override
            public void onResponse(Call<MusicRoot> call, Response<MusicRoot> response) {
                if (response.isSuccessful()){
                    MusicRoot muscicRoot = response.body();
                    musicRoots = muscicRoot.getData();
                    Log.d("gank","music"+" "+muscicRoot.getRes());
                    adapter.addAll(musicRoots);
                }
            }

            @Override
            public void onFailure(Call<MusicRoot> call, Throwable t) {
                Log.d("gank","music");
            }
        });
    }



}


