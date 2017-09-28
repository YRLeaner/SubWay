package com.example.tyr.subway3;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.tyr.subway3.DownLoad.DownloadService;
import com.example.tyr.subway3.DownLoad.Fileinfo;
import com.example.tyr.subway3.FragmentAdapter.VideoRecyclerViewAdapter;
import com.example.tyr.subway3.Service.VideoService;
import com.example.tyr.subway3.Utils.RetrofitInit;
import com.example.tyr.subway3.beans.VideoRoot;
import com.example.tyr.subway3.view.NiceNotification;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlarmReceiver extends BroadcastReceiver {
    private List<VideoRoot.ItemList> lists;
    QueryObservable queryObservable;
    QueryObserver queryObserver;
@Override
public void onReceive(Context context, Intent intent) {
    Log.d("LongRunningService", "receiver");
    lists = new ArrayList<>();
    queryObservable = new QueryObservable();
    queryObserver = new QueryObserver(queryObservable,context);
    SharedPreferences sharedPreferences = context.getSharedPreferences("SubWay3",Context.MODE_PRIVATE);
    boolean isChecked = sharedPreferences.getBoolean("check", false);
    long time = sharedPreferences.getLong("time", 0);

    SharedPreferences sharedPreferences1 = context.getSharedPreferences("videolike", Context.MODE_PRIVATE);
    String like = sharedPreferences1.getString("videoliketype", "搞笑");
    int start = sharedPreferences1.getInt("videostart", 0);
    String action = intent.getAction();
    if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
        ConnectivityManager localConnectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo localNetworkInfo = (localConnectivityManager == null ? null
                : localConnectivityManager.getActiveNetworkInfo());
        if (localNetworkInfo != null) {
            if (localNetworkInfo.isConnected()) {
                //已连接
                if (isChecked&&(System.currentTimeMillis()-time)>60000){
                    Log.d("receiver", "开始下载");
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putLong("time",System.currentTimeMillis());
                    editor.commit();
                    VideoRetrofi(like, start);
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    editor1.putInt("videostart",start+5);
                    editor1.commit();
                }
                Log.d("receiver","已连接");
            } else {
                //断开连接
                //失效
                Log.d("receiver","断开连接");
            }
        } else {
            //localNetworkInfo is null, NETWORK................DISCONNECT......
        }
    }

    }



    private void VideoRetrofi(String like,int start){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://baobab.kaiyanapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        VideoService service = retrofit.create(VideoService.class);
        final Call<VideoRoot> repos = service.getVideos("3",like,String.valueOf(start));
        repos.enqueue(new Callback<VideoRoot>() {
            @Override
            public void onResponse(Call<VideoRoot> call, Response<VideoRoot> response) {
                VideoRoot videoRoot = response.body();
                for (VideoRoot.ItemList bean:videoRoot.getItemList()){
                    Log.d("receiver", bean.getData().getPlayUrl());
                }
                lists.addAll(videoRoot.getItemList());
                queryObservable.setData(1);
            }

            @Override
            public void onFailure(Call<VideoRoot> call, Throwable t) {
                Log.d("receiver", "video" + t.toString());
            }
        });

    }


    public class QueryObservable extends Observable{
        private int data = 0;
        public int getData(){
            return  data;
        }
        public void setData(int i){
            if (this.data!=i){
                setChanged();
                notifyObservers();
            }
        }
    }


    public class QueryObserver implements Observer{
        Context context;
        public QueryObserver(QueryObservable queryObservable,Context context) {
            queryObservable.addObserver(this);
            this.context = context;
        }

        @Override
        public void update(Observable o, Object arg) {
            Log.d("receiver","shodao");
            for (int i=0;i<3;i++){
                Fileinfo fileinfo = new Fileinfo(0,lists.get(i).getData().getPlayUrl(),
                        i+".mp4",0,0);
                Intent intent = new Intent(context, DownloadService.class);
                intent.setAction(DownloadService.ACTION_START);
                intent.putExtra("fileinfo",fileinfo);
                context.startService(intent);
                NiceNotification.init(context
                );
            }
        }
    }
}
