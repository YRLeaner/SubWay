package com.example.tyr.subway3;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Camera;
import android.net.ConnectivityManager;

import com.example.tyr.subway3.callback.CustomCallback;
import com.example.tyr.subway3.callback.EmptyCallback;
import com.example.tyr.subway3.callback.ErrorCallback;
import com.example.tyr.subway3.callback.LoadingCallback;
import com.example.tyr.subway3.callback.TimeoutCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * Created by tyr on 2017/8/23.
 */
public class MainApplication extends Application {

    private int film_start=0;
    private int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter =new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        AlarmReceiver receiver = new AlarmReceiver();
        registerReceiver(receiver, filter);

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(EmptyCallback.class)
                .commit();

    }

    public int getFilm_start() {
        return film_start;
    }

    public void setFilm_start(int film_start) {
        this.film_start = film_start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
