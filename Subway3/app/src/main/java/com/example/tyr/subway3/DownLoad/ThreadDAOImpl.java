package com.example.tyr.subway3.DownLoad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyr on 2017/4/22.
 */
public class ThreadDAOImpl implements ThreadDao {
    private DBHelper mHepler = null;
    public ThreadDAOImpl(Context context){
        mHepler = new DBHelper(context);
    }

    @Override
    public void insertThread(Threadinfo threadinfo) {
        SQLiteDatabase db = mHepler.getWritableDatabase();
        db.execSQL("insert into thread_info(thread_id,url,start,end,finished) values(?,?,?,?,?)",
        new Object[]{
                threadinfo.getId(),threadinfo.getUrl(),threadinfo.getStart(),threadinfo.getEnd(),threadinfo.getFinished()
        });
        db.close();
    }

    @Override
    public void deleteThread(String url, int thread_id) {
        SQLiteDatabase db = mHepler.getWritableDatabase();
        db.execSQL("delete from thread_info where url= ? and thread_id= ?",
                new Object[]{url,thread_id});
        db.close();
    }

    @Override
    public void updateThread(String url, int thread_id, long finished) {
        SQLiteDatabase db = mHepler.getWritableDatabase();
        db.execSQL("update thread_info set finished = ? where url= ? and thread_id= ?",
                new Object[]{finished,url,thread_id});
        db.close();
    }

    @Override
    public List<Threadinfo> getThreads(String url) {
        SQLiteDatabase db = mHepler.getWritableDatabase();
        List<Threadinfo> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select*from thread_info where url = ?", new String[]{url});
        while (cursor.moveToNext()){
            Threadinfo threadinfo = new Threadinfo();
            threadinfo.setId(cursor.getInt(cursor.getColumnIndex("thread_id")));
            threadinfo.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            threadinfo.setStart(cursor.getLong(cursor.getColumnIndex("start")));
            threadinfo.setEnd(cursor.getLong(cursor.getColumnIndex("end")));
            threadinfo.setFinished(cursor.getLong(cursor.getColumnIndex("finished")));
            list.add(threadinfo);
        }
        cursor.close();
        db.close();
        return list;
    }

    @Override
    public boolean isExists(String url, int thread_id) {
        SQLiteDatabase db = mHepler.getWritableDatabase();

        Cursor cursor = db.rawQuery("select*from thread_info where url = ? and thread_id= ?", new String[]{url,thread_id+""});
        boolean exists = cursor.moveToNext();
        cursor.close();
        db.close();
        return exists;
    }
}
