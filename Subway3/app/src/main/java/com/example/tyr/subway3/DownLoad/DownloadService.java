package com.example.tyr.subway3.DownLoad;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tyr on 2017/4/22.
 */
public class DownloadService extends Service {
    public static final String DOWNLOAD_PATH =
            Environment.getExternalStorageDirectory().getAbsolutePath()+"/downloads/SubWay3/";
    public static final String ACTION_START = "ACTION_START";
    public static final String ACTION_STOP = "ACTION_STOP";
    public static final String ACTION_UPDATA = "ACTION_UPDATA";
    public static final int  MSG_INIT = 0;
    private DownTask downTask;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (ACTION_START.equals(intent.getAction())){
            Fileinfo fileinfo =(Fileinfo) intent.getSerializableExtra("fileinfo");
            Log.i("test","start "+fileinfo.toString());

            new InitThread(fileinfo).start();
        }else if (ACTION_STOP.equals(intent.getAction())){
            Fileinfo fileinfo =(Fileinfo) intent.getSerializableExtra("fileinfo");
            Log.i("test","stop "+fileinfo.toString());

            if (downTask!=null){
                downTask.isPause = true;
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_INIT:
                    Fileinfo fileinfo = (Fileinfo)msg.obj;
                    Log.d("test","Init"+fileinfo);
                    //启动下载任务
                    downTask = new DownTask(fileinfo,DownloadService.this);
                    downTask.download();
                    break;
            }
        }
    };

    class InitThread extends Thread{
        private Fileinfo fileinfo = null;

        public InitThread(Fileinfo fileinfo) {
            this.fileinfo = fileinfo;
        }

        @Override
        public void run() {
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            try {
                URL url = new URL(fileinfo.getUrl());
                conn = (HttpURLConnection)url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                int length = -1;
                if (conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    length = conn.getContentLength();
                }
                if (length<0){
                    return;
                }
                File dir = new File(DOWNLOAD_PATH);
                if (!dir.exists()){
                    dir.mkdir();
                }

                File file = new File(dir,fileinfo.getFileName());
                raf = new RandomAccessFile(file,"rwd");
                raf.setLength(length);
                fileinfo.setLength(length);
                handler.obtainMessage(MSG_INIT,fileinfo).sendToTarget();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (conn!=null&&raf!=null){
                        raf.close();
                        conn.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
