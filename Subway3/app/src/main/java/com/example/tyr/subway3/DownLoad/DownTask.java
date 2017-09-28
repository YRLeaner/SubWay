package com.example.tyr.subway3.DownLoad;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by tyr on 2017/4/22.
 */
public class DownTask {
    private Context mContext;
    private Fileinfo mFileInfo = null;
    private ThreadDao mDao = null;
    private long mFinished = 0;
    public boolean isPause = false;

    public DownTask(Fileinfo mFileInfo, Context mContext) {
        this.mFileInfo = mFileInfo;
        this.mContext = mContext;
        mDao = new ThreadDAOImpl(mContext);
    }

    public void download(){
        //读取数据库信息
        List<Threadinfo> threadinfos = mDao.getThreads(mFileInfo.getUrl());
        Log.d("test", threadinfos.size() + "threadinfos.size");
        Threadinfo threadinfo = null;
        if (threadinfos.size()==0){
            threadinfo = new Threadinfo(0,mFileInfo.getUrl(),0,mFileInfo.getLength(),0);
        }else {
            threadinfo = threadinfos.get(0);
        }

        new DownloadThread(threadinfo).start();
    }

    class DownloadThread extends Thread{
        private Threadinfo mThreadInfo = null;
        public DownloadThread(Threadinfo mThreadInfo){
            this.mThreadInfo = mThreadInfo;
        }

        @Override
        public void run() {
            if (!mDao.isExists(mThreadInfo.getUrl(),mThreadInfo.getId())){
                mDao.insertThread(mThreadInfo);
            }
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            InputStream input = null;
            try {
                Log.d("test","yes");
                URL url = new URL(mThreadInfo.getUrl());
                conn = (HttpURLConnection)url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                //设置下载位置
                long start = mThreadInfo.getStart()+mThreadInfo.getFinished();
                conn.setRequestProperty("Range", "bytes=" + start + "-" + mThreadInfo.getEnd());
                //设置文件写入位置
                File file = new File(DownloadService.DOWNLOAD_PATH,mFileInfo.getFileName());
                 raf = new RandomAccessFile(file,"rwd");
                raf.seek(start);
                Log.d("test", "yes2");
                Intent intent = new Intent(DownloadService.ACTION_UPDATA);
                mFinished+=mThreadInfo.getFinished();
                Log.d("test", "threadInfo.getFinish=="+mThreadInfo.getFinished() + "");
                Log.d("test", "response code"+conn.getResponseCode() + "");
                //开始下载
                if (conn.getResponseCode()==HttpURLConnection.HTTP_PARTIAL){
                    Log.d("test", "getContentLength=="+conn.getContentLength()+ "");
                    input = conn.getInputStream();
                    byte[] buffer = new byte[1024*4];
                    int len = -1;
                    long time = System.currentTimeMillis();
                    while ((len=input.read(buffer))!=-1){
                        //写入文件
                        raf.write(buffer,0,len);
                        //把下载进度广播
                        mFinished+=len;
                        if (System.currentTimeMillis()-time>500) {
                            time = System.currentTimeMillis();
                            intent.putExtra("finished", (int)(mFinished * 100 / mFileInfo.getLength()));
                            Log.d("test", "semnd");
                            mContext.sendBroadcast(intent);
                            Log.e("test", " mFinished percent==="+mFinished * 100 / mFileInfo.getLength() + "");
                        }

                        //下载暂停，保存进度
                        if (isPause){
                            Log.d("test", mFinished + "mFinished");
                            mDao.updateThread(mThreadInfo.getUrl(), mThreadInfo.getId(),mFinished);
                            return;
                        }
                    }
                    intent.putExtra("finished",100);
                    mContext.sendBroadcast(intent);
                    mDao.deleteThread(mThreadInfo.getUrl(),mThreadInfo.getId());
                    input.close();
                }
                raf.close();
                conn.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }/* finally {
                conn.disconnect();
                try {
                    input.close();
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }*/
        }
    }
}
