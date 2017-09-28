package com.example.tyr.subway3.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tyr.subway3.FragmentAdapter.DuanZiRecyclerViewAdapter;
import com.example.tyr.subway3.MainApplication;
import com.example.tyr.subway3.R;


import com.example.tyr.subway3.Service.DuanZiService;
import com.example.tyr.subway3.Utils.RetrofitInit;
import com.example.tyr.subway3.activity.SmileActivity;
import com.example.tyr.subway3.beans.DuanZiBean;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFGridLayoutManager;
import com.sch.rfview.manager.AnimRFStaggeredGridLayoutManager;

import java.io.Serializable;
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
public class XSmileFragment extends BaseFragment {

    private static final boolean GRID_LAYOUT = true;
    private static final int ITEM_COUNT = 100;
    private List<DuanZiBean.Datum> duanzis;
    private Context context;
    private DuanZiRecyclerViewAdapter adapter;
    @BindView(R.id.smile_recyclerView)
    AnimRFRecyclerView mRecyclerView;

    private View headerView;
    private View footerView;
    private Handler mHandler = new Handler();

    MainApplication mainApplication;

    public static XSmileFragment newInstance() {
        return new XSmileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.smile_fragment, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainApplication = (MainApplication)getActivity().getApplicationContext();
        duanzis = new ArrayList<>();
        context =getActivity();

        initLayout();
        //setup materialviewpager
        //DuanZiRetrofi();
        initDuanZiRetrofit();
    }

    private void initLayout() {
        footerView = LayoutInflater.from(getActivity()).inflate(R.layout.footer_view,null);
        mRecyclerView.addFootView(footerView);
        adapter = new DuanZiRecyclerViewAdapter(duanzis,context);

        if (GRID_LAYOUT) {
            //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            mRecyclerView.setLayoutManager(new AnimRFStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        adapter.setOnItemClickListener(new OnMyItemClickListener() {
            @Override
            public void itemClick(View v, int position) {
                Toast.makeText(context, "hah", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SmileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("duanzi", (Serializable) duanzis);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
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
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
                       /* refreshComplate();
                        // 刷新完成后调用，必须在UI线程中
                        mRecyclerView.refreshComplate();*/
                    } else {
                        //addData();
                        Log.d("re","刷新2");
                        initDuanZiRetrofit();

                        Message handleMsg = new Message();
                        handleMsg.what = 2;
                        updateChatHandler.sendMessage(handleMsg);
                     /*   loadMoreComplate();
                        // 加载更多完成后调用，必须在UI线程中
                        mRecyclerView.loadMoreComplate();*/
                    }
                }
            }, 2000);
        }
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

    public void refreshComplate() {
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    public void loadMoreComplate() {
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private void initDuanZiRetrofit() {
        RetrofitInit init = new RetrofitInit(getActivity(),"http://is.snssdk.com/");
        DuanZiService service = init.initRetrofit().create(DuanZiService.class);

        Call<DuanZiBean> repos = service.getDuanZi(System.currentTimeMillis()/1000L);
       // mainApplication.setCount(count+1);
        repos.enqueue(new Callback<DuanZiBean>() {
            @Override
            public void onResponse(Call<DuanZiBean> call, Response<DuanZiBean> response) {
                Log.d("gank", "succSmile");
                if (response.isSuccessful()) {
                    DuanZiBean result = response.body();
                    for (DuanZiBean.Datum bean : result.getData().getData()) {
                        //  Log.d("gank", bean.getGroup().getText());
                        if (bean.getType().equals("1")) {
                            duanzis.add(bean);
                        }
                    }
                    adapter.addAll(duanzis);
                    Message handleMsg = new Message();
                    handleMsg.what = 1;
                    updateChatHandler.sendMessage(handleMsg);
                }

            }

            @Override
            public void onFailure(Call<DuanZiBean> call, Throwable t) {
                Log.d("gank", "failureSmile");
                Log.d("gank", t.toString());
            }
        });
    }





}


