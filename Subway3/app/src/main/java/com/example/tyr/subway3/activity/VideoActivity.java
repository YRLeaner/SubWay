package com.example.tyr.subway3.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.tyr.subway3.MyVideoView;
import com.example.tyr.subway3.R;

/**
 * Created by tyr on 2017/8/31.
 */

public class VideoActivity extends AppCompatActivity {
    MyVideoView myVideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_main);
        myVideoView = (MyVideoView)findViewById(R.id.video_main_video);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("videoUrl");
        Log.d("video",url);
        myVideoView.setFullScreen();
        myVideoView.setPlayData(url);
        myVideoView.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

    }

    @Override
    protected void onDestroy() {
        myVideoView.destroy();
        super.onDestroy();

    }
}
