package com.example.tyr.subway3.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tyr.subway3.FragmentAdapter.VideoRecyclerViewAdapter;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Service.VideoService;

import com.example.tyr.subway3.Utils.RetrofitInit;
import com.example.tyr.subway3.beans.VideoRoot;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tyr on 2017/8/19.
 */
public class XVideoFragment extends BaseFragment {
    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private VideoRoot videoRoot;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    int[] like = new int[6];
    SharedPreferences sharedPreferences;
    private StringBuilder likeStr;
    String[] string = {"音乐MV", "卡通动漫", "游戏天地", "幽默搞笑", "鬼畜", "微电影"};

    LoadService loadService;
    public static XVideoFragment newInstance() {
        return new XVideoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.video_fragment, container, false);
        ButterKnife.bind(this, rootView);
        loadService = LoadSir.getDefault().register(rootView, new com.kingja.loadsir.callback.Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showSuccess();
            }
        });
        return loadService.getLoadLayout();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initDate();

        initVideoRetro();
      //  VideoRetrofi();

        //setup materialviewpager

    }

    private void initDate() {
            Log.d("gank","shared");
            likeStr = new StringBuilder();
            sharedPreferences = getActivity().getSharedPreferences("videolike", getActivity().MODE_PRIVATE);
            like[0] = sharedPreferences.getInt("音乐MV", 0);
            like[1] = sharedPreferences.getInt("卡通动漫", 0);
            like[2] = sharedPreferences.getInt("游戏天地",0);
            like[3] = sharedPreferences.getInt("幽默搞笑",0);
            like[4] = sharedPreferences.getInt("鬼畜",0);
            like[5] = sharedPreferences.getInt("微电影",0);



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

    private void initVideoRetro() {
        RetrofitInit init = new RetrofitInit(getActivity(),"http://baobab.kaiyanapp.com/api/");
        VideoService service = init.initRetrofit().create(VideoService.class);
        final Call<VideoRoot> repos = service.getVideos("3",likeStr.toString(),"5");
        repos.enqueue(new Callback<VideoRoot>() {
            @Override
            public void onResponse(Call<VideoRoot> call, Response<VideoRoot> response) {
                videoRoot = response.body();

                if (GRID_LAYOUT) {
                    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                } else {
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
                mRecyclerView.setHasFixedSize(true);

                //Use this now
                mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
                mRecyclerView.setAdapter(new VideoRecyclerViewAdapter(videoRoot,getActivity()));
            }

            @Override
            public void onFailure(Call<VideoRoot> call, Throwable t) {
                Log.d("gank", "video" + t.toString());
            }
        });
    }


}
