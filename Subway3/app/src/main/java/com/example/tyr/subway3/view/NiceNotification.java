package com.example.tyr.subway3.view;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.example.tyr.subway3.MainActivity;
import com.example.tyr.subway3.R;

/**
 * Created by tyr on 2017/9/10.
 */

public class NiceNotification {

    public static void init(Context mContext){
        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext)
                //设置小图标
                .setSmallIcon(R.drawable.icon)
                //设置通知标题
                .setContentTitle("最简单的Notification")
                //设置通知内容
                .setContentText("只有小图标、标题、内容");
        //设置通知时间，默认为系统发出通知的时间，通常不用设置
        //.setWhen(System.currentTimeMillis());
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        notifyManager.notify(1, builder.build());

    }

}
